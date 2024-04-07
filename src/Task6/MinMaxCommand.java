package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

/** Задача, що використовується обробником потоку
 * Знаходить найменше додатнє та найбільше від'ємне число результату
 * шаблон Worker Thread
 * @author Яценко Віталій
 * @see Command
 * @see CommandQueue
 */
public class MinMaxCommand implements Command {
    
    /** Зберігає результат обробки колекції */
    private int resultMin = -1;
    
    /** Зберігає результат обробки колекції */
    private int resultMax = -1;
    
    /** Позначка готовності результату */
    private int progress = 0;
    
    /** Обслуговує колекцію об'єктів {@linkplain Task2.Item2d} */
    private ViewResult viewResult;
    
    /** Повертає поле {@linkplain MinMaxCommand#viewResult}
     * @return значення {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    
    /** Встановлює поле {@linkplain MinMaxCommand#viewResult}
     * @param viewResult значення для {@linkplain MinMaxCommand#viewResult}
     * @return нове значення {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    
    /** Ініціалізує поле {@linkplain MinMaxCommand#viewResult}
     * @param viewResult об'єкт класа {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    
    /** Повертає результат
     * @return поле {@linkplain MinMaxCommand#result}
     */
    public int getResultMin() {
        return resultMin;
    }
    
    /** Повертає результат
     * @return поле {@linkplain MinMaxCommand#result}
     */
    public int getResultMax() {
        return resultMax;
    }
    
    /** Перевіряє результат на готовність
     * @return false - результат не знайдено, true – знайдено
     */
    public boolean running() {
        return progress < 100;
    }
    
    /** Використовується обробнком потока {@linkplain CommandQueue};
     * шаблон Worker Thread
     */
    @Override
    public void execute(){
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for(Item2d item : viewResult.getItems()){
            if(item.getSCells() < 0){
                if((resultMax == -1) || (viewResult.getItems().get(resultMax).getSCells() < item.getSCells())){
                    resultMax = idx;
                }
            } else {
                    if((resultMin == -1) || (viewResult.getItems().get(resultMin).getSCells() > item.getSCells())){
                        resultMin = idx;
                    }
                }
                idx++;
                progress = idx * 100 / size;
                if(idx % (size / 5) == 0){
                    System.out.println("MinMax " + progress + "%");
                }
                try{
                    TimeUnit.MILLISECONDS.sleep(5000 / size);
                } catch (InterruptedException e){
                    System.err.println(e);
                }
            }
            System.out.println("MinMax done. ");
            if(resultMin > -1){
                System.out.print("\nMin positive #" + resultMin + " found: " + String.format("%d.", viewResult.getItems().get(resultMin).getSCells()));
            }
            else{
                System.out.println("Min positive not found.");
            }
            if(resultMax > -1){
                System.out.print(" Max negative #" + resultMax + " found: " + String.format("%d.", viewResult.getItems().get(resultMin).getSCells()) + "\n");
            }
            else{
                System.out.println(" Max negative not found.\n");
            }
            progress = 100;
        } 
}
