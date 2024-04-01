package Task2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 * Клас для знаходження кількості клітин, що вижили на заданому циклі поділу
 *
 * @author Яценко Віталій
 */
public class Calc {
    /**Ім'я файлу, що використовується при серіалізації */
    private static final String FNAME = "Item2d.bin";
    /**Зберігає результати обчислень. Об'єкт класу {@linkplain Item2d} */
    private Item2d result;
    
    /**Ініціалізує {@linkplain Calc#result} */
    public Calc (){
        result = new Item2d();
    }
    
    /** Встановити значення {@linkplain Calc#result}
    * @param result - нове значення посилання на об'єкт {@linkplain Item2d}
    */
    public void setResult(Item2d result){
        this.result = result;
    }
    
    /** Отримати значення {@linkplain Calc#result}
    * @return поточне значення посилання на об'єкт {@linkplain Item2d}
    */
    public Item2d getResult(){
        return result;
    }
    
    /**Обраховує кількість клітин, що вижили на заданому циклі поділу
     * @param primaryCells int значення, початкова кількість клітин (до поділу) 
     * @param cycles int значення, кількість циклів
     * @return кількість клітин, що вижили після проходження циклів поділу
     */
    private int calc(int primaryCells, int cycles){
        Random random = new Random();
        int survivingCells = primaryCells;
        
        final double MIN_FAVOURABLE_DEATHRATE = 0.1; final double MAX_FAVOURABLE_DEATHRATE = 0.5;
        final double MIN_UNFAVOURABLE_DEATHRATE = 0.5; final double MAX_UNFAVOURABLE_DEATHRATE = 0.9;
        
        double minDeathrate; double maxDeathrate;
        double deathrate; double survivalrate;
        
        boolean favourableConditions = random.nextInt(0, 10) % 2 == 0;
        for(int i = 1; i <= cycles;i++){
            if(favourableConditions) { minDeathrate = MIN_FAVOURABLE_DEATHRATE; maxDeathrate = MAX_FAVOURABLE_DEATHRATE; }
            else{ minDeathrate = MIN_UNFAVOURABLE_DEATHRATE; maxDeathrate = MAX_UNFAVOURABLE_DEATHRATE;}
            
            deathrate = random.nextDouble() * (maxDeathrate - minDeathrate) + minDeathrate;
            survivalrate = 1 - deathrate; 
            survivingCells *= survivalrate;
        }
        return survivingCells;
    }
    
    /** Обчислює кількість клітин, що вижили після проходження циклів поділу, та зберігає
    * результат в об'єкті {@linkplain Calc#result}
    * @param primaryCells int значення, початкова кількість клітин (до поділу) 
    * @param cycles int значення, кількість циклів
    */
    public int init(int primaryCells, int cycles){
        result.setPCells(primaryCells);
        result.setCycles(cycles);
        return result.setSCells(calc(primaryCells, cycles));
    }
    
    /**Відображає значення об'єкту */
    public void show(){
        System.out.println(result);
    }
    
    /**Зберігає {@linkplain Calc#result} в файлі {@linkplain Calc#FNAME}
    * @throws IOException
    */
    public void save() throws IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }
    /**Відновлює {@linkplain Calc#result} з файлу {@linkplain Calc#FNAME}
    * @throws Exception
    */
    public void restore() throws Exception{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}
