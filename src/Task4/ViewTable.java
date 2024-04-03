package Task4;

import java.util.Formatter;
import Task2.Item2d;
import Task3.ViewResult;

/** Concrete Product
 * шаблон проектування Factory Method
 * Відображення результатів у вигляді таблиці
 * @author Яценко Віталій
 * @see ViewResult
 */
public class ViewTable extends ViewResult{
    
    /** Ширина таблиці за замовчуванням */
    private static final int DEFAULT_WIDTH = 50;
    
    /** Поточна ширина таблиці */
    private int width;
    
    /** Встановлює {@linkplain ViewTable#width width}
     * значенням {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * Викликає конструктор батьківського класу {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable(){
        width = DEFAULT_WIDTH;
    }
    
    /** Встановлює {@linkplain ViewTable#width width} значенням <b>width</b><br>
     * Викликає конструктор батьківського класу {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * @param width ширина таблиці
     * @param n кількість елементів колекції; передається батьківському класу
     */
    public ViewTable(int width, int n){
        super(n);
        this.width = width;
    }
    
    /** Встановлює поле {@linkplain ViewTable#width} значением <b>width</b>
     * @param width нова ширина таблиці
     * @return ширина таблиці, задана параметром <b>width</b>
     */
    public int setWidth(int width){
        return this.width = width;
    }
    
    /** Повертає значення поля {@linkplain ViewTable#width}
     * @return Поточна ширина таблиці
     */
    public int getWidth(){
        return width;
    }
    
    /** Виводить на екран вертикальну полосу-розділювач шириною {@linkplain ViewTable#width} символів */
    private void outLine(){
        for(int i = width+30; i > 0; i--){
            System.out.printf("-");
        }
    }
    
    /** Викликає {@linkplain ViewTable#outLine()}; завершує вивід розділювачем рядку */
    private void outLineLn(){
        outLine();
        System.out.println();
    }
    
    /** Виводить заголовок таблиці з назвами даних шириною в {@linkplain ViewTable#width} символів */
    private void outHeader(){
        Formatter formatter = new Formatter();
        formatter.format("%-" + (width-3)/2 + "s | %-" + (width-3)/2 + "s | %s", "Number of primary cells", "Number of cycles", "Number of surviving cells\n");
        System.out.printf(formatter.toString());
    }
    
    /** Виводить тіло таблиці з даними шириною в {@linkplain ViewTable#width} символів */
    private void outBody(){
        for(Item2d item : getItems()){
            Formatter formatter = new Formatter();
            formatter.format("%-" + (width-3)/2 + "d | %-" + (width-3)/2 + "s | %d%n", item.getPCells(), item.getCycles(), item.getSCells());
            System.out.printf(formatter.toString());
        }
    }
    
    /** Overload метода батьківського класу;
     * Встановлює поле {@linkplain ViewTable#width} значенням <b>width</b><br>
     * Викликає метод {@linkplain ViewResult#viewInit() viewInit()}
     * @param width нова ширина таблиці
     */
    public final void init(int width){
        this.width = width;
        viewInit();
    }
    
    /** Overload метода батьківського класу;
     * Встановлює поле {@linkplain ViewTable#width} значенням <b>width</b><br>
     * Для об'єкту {@linkplain ViewTable} викликає метод {@linkplain ViewTable#init(int, int)}
     * @param width нова ширина таблиці
     * @param stepPC передається методу <b>init(int, int)</b>
     * @param stepCyc передається методу <b>init(int, int)</b>
     */
    public final void init(int width, int stepPC, int stepCyc){
        this.width = width;
        init(stepPC, stepCyc);
    }
    
    /** Override метода батьківського класу;
     * Виводить інформаційне повідомлення про ініціалізацію та викликає метод батьківського класу
     * {@linkplain ViewResult#init(int stepPC, int stepCyc) init(int stepPC, int stepCyc)}<br>
     * {@inheritDoc}
     */
    @Override
    public void init(int stepPC, int stepCyc){
        System.out.print("Initialization...\n");
        super.init(stepPC, stepCyc);
        System.out.println("Done.\n");
    }
    
    /** Вивід елемента таблиці (заголовку)<br>{@inheritDoc} */
    @Override
    public void viewHeader(){
        outHeader();
        outLineLn();
    }
    
    /** Вивід елемента таблиці (тіла)<br>{@inheritDoc} */
    @Override
    public void viewBody(){
        outBody();
    }
    
    /** Вивід елемента таблиці (футеру)<br>{@inheritDoc} */
    @Override
    public void viewFooter(){
        outLineLn();
    }
}
