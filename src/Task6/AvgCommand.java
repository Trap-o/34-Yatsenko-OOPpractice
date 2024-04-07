package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;

/** Задача, що використовується обробником потоку
 * Знаходить середнє арифметичне результатів обчислення
 * шаблон Worker Thread
 * @author Яценко Віталій
 * @see Command
 * @see CommandQueue
 */
public class AvgCommand implements Command {
    
    /** Зберігає результат обробки колекції */
    private int result = 0;
    
    /** Позначка готовності результату */
    private int progress = 0;
    
    /** Обслуговує колекцію об'єктів {@linkplain Task2.Item2d} */
    private ViewResult viewResult;
    
    /** Повертає поле {@linkplain AvgCommand#viewResult}
     * @return значення {@linkplain AvgCommand#viewResult}
     */
    public ViewResult getViewResult(){
        return viewResult;
    }
    
    /** Встановлює поле {@linkplain AvgCommand#viewResult}
     * @param viewResult значення для {@linkplain AvgCommand#viewResult}
     * @return нове значення {@linkplain AvgCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult){
        return this.viewResult = viewResult;
    }
    
    /** Ініціалізує поле {@linkplain AvgCommand#viewResult}
     * @param viewResult об'єкт класа {@linkplain ViewResult}
     */
    public AvgCommand(ViewResult viewResult){
        this.viewResult = viewResult;
    }
    
    /** Повертає результат
     * @return поле {@linkplain AvgCommand#result}
     */
    public int getResult(){
        return result;
    }
    
    /** Перевіряє результат на готовність
     * @return false - результат не знайдено, true – знайдено
     * @see AvgCommand#result
     */
    public boolean running(){
        return progress < 100;
    }
    
    /** Використовується обробнком потока {@linkplain CommandQueue};
     * шаблон Worker Thread
     */
    @Override
    public void execute(){
        progress = 0;
        System.out.println("Average executed...");
        result = 0;
        int idx = 1, size = viewResult.getItems().size();
        for(Item2d item : viewResult.getItems()){
            result += item.getSCells();
            progress = idx * 100 / size;
            if(idx++ % (size / 2) == 0){
                System.out.println("Average " + progress + "%");
            }
            try{
                TimeUnit.MILLISECONDS.sleep(2000/size);
            } catch(InterruptedException e){
                System.err.println(e);
            }
        }
        result /= size;
        System.out.println("\nAverage number of surviving cells done. Result = " + String.format("%d", result) + "\n");
    }
}
