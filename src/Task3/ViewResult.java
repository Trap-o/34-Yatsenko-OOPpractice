package Task3;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.ArrayList;
import Task2.Item2d;

/** Concrete Product
 * шаблон проектування Factory Method
 * Знаходження кількості клітин, що вижили на заданому циклі поділу, збереження та відображення результатів
 * @author Яценко Віталій
 * @see View
 */
public class ViewResult implements View{
    /**Ім'я файлу, що використовується при серіалізації */
    private static final String FNAME = "items.bin";
    /**Визначає кількість значень, що обраховується за замовчуванням */
    private static final int DEFAULT_NUM = 10;
    /**Колекція аргументів та результатів обчислень */
    private ArrayList<Item2d> items = new ArrayList<Item2d>();
    /** 
     * Викликає {@linkplain ViewResult#ViewResult(int) ViewResult(int n)}
     * з параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult(){
        this(DEFAULT_NUM);
    }
    /** 
     * Ініціалізує колекцію {@linkplain ViewResult#items}
     * @param n початкова кількість елементів
     */
    public ViewResult(int n){
        for(int ctr = 0; ctr < n; ctr++)
            items.add(new Item2d());    
    }
    /** 
     * Отримує значення {@linkplain ViewResult#items}
     * @return поточне значення посилання на об'єкт {@linkplain ArrayList}
     */
    public ArrayList<Item2d> getItems(){
        return items;
    }
    /**Обраховує кількість клітин, що вижили на заданому циклі поділу
     * @param primaryCells int значення, початкова кількість клітин (до поділу) 
     * @param cycles int значення, кількість циклів
     * @return кількість клітин, що вижили після проходження циклів поділу
     */
    public int calc(int primaryCells, int cycles){
        Random random = new Random();
        int survivingCells = primaryCells;
        
        final double MIN_FAVOURABLE_DEATHRATE = 0.1; final double MAX_FAVOURABLE_DEATHRATE = 0.5;
        final double MIN_UNFAVOURABLE_DEATHRATE = 0.5; final double MAX_UNFAVOURABLE_DEATHRATE = 0.9;
        double minDeathrate; double maxDeathrate;
        double deathrate; double survivalrate;
        
        boolean favourableConditions = random.nextInt(0, 10) % 2 == 0;
        for(int i = 1; i <= cycles;i++){
            if(favourableConditions) {minDeathrate = MIN_FAVOURABLE_DEATHRATE; maxDeathrate = MAX_FAVOURABLE_DEATHRATE;}
            else{minDeathrate = MIN_UNFAVOURABLE_DEATHRATE; maxDeathrate = MAX_UNFAVOURABLE_DEATHRATE;}
            
            deathrate = random.nextDouble() * (maxDeathrate - minDeathrate) + minDeathrate;
            survivalrate = 1 - deathrate; 
            survivingCells = (int)(survivingCells * survivalrate);
        }
        return survivingCells;
    }
    /** Обчислює кількість клітин, що вижили після проходження циклів поділу, та зберігає
     * результат в колекції {@linkplain ViewResult#items}
     * @param stepPC крок збільшення кількікості клітин
     * @param stepCyc крок збільшення кількості циклів
     */
    public void init(int stepPC, int stepCyc){
        int primaryCells = 1000, cycles = 1;
        for(Item2d item : items){
            item.setCyclesAndPSCells(primaryCells, cycles, calc(primaryCells, cycles));
            primaryCells += stepPC; cycles += stepCyc;
        }
    }
    /** Викликає <b>init(int stepPC, int stepCyc)</b> 
     * з випадковими значеннями кількікості клітин та циклів<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit(){
        Random random = new Random();
        init(random.nextInt(1001)+1, random.nextInt(11)+1);
    }
    /** Реалізація методу {@linkplain View#viewSave()}<br> * {@inheritDoc} */
    @Override
    public void viewSave() throws IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush(); os.close();
    }
    /** Реалізація методу {@linkplain View#viewRestore()}<br> {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>)is.readObject();
        is.close();
    }
    /** Реалізація методу {@linkplain View#viewHeader()}<br> {@inheritDoc} */
    @Override
    public void viewHeader(){
        System.out.println("Results: ");
    }
    /** Реалізація методу {@linkplain View#viewBody()}<br> {@inheritDoc} */
    @Override
    public void viewBody(){
        for(Item2d item : items){
            System.out.printf("\nNumber of primary cells: " + item.getPCells());
            System.out.printf(", number of cycles: " + item.getCycles());
            System.out.printf(", number of surviving cells: " + item.getSCells());
            System.out.println("");
        }
    }
    /** Реалізація методу {@linkplain View#viewFooter()}<br> {@inheritDoc} */
    @Override
    public void viewFooter(){
        System.out.println("\nEnd.");
    }
    /** Реалізація методу {@linkplain View#viewShow()}<br> {@inheritDoc} */
    @Override
    public void viewShow(){
        viewHeader();
        viewBody();
        viewFooter();
    }
}
