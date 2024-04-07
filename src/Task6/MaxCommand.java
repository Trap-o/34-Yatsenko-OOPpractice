package Task6;

import java.util.concurrent.TimeUnit;
import Task3.ViewResult;
import Task5.Command;

/** Задача, що використовується обробником потоку
 * Знаходить елемент колекції з найбільшим числом результату
 * шаблон Worker Thread
 * @author Яценко Віталій
 * @see Command
 * @see CommandQueue
 */
public class MaxCommand implements Command{
    
    /** Зберігає результат обробки колекції */
    private int result = -1;
    
    /** Позначка готовності результату */
    private int progress = 0;
    
    /** Обслуговує колекцію об'єктів {@linkplain Task2.Item2d} */
    private ViewResult viewResult;
    
    /** Повертає поле {@linkplain MaxCommand#viewResult}
     * @return значення {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    
    /** Встановлює поле {@linkplain MaxCommand#viewResult}
     * @param viewResult значення для {@linkplain MaxCommand#viewResult}
     * @return нове значення {@linkplain MaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    
    /** Ініціалізує поле {@linkplain MaxCommand#viewResult}
     * @param viewResult об'єкт класа {@linkplain ViewResult}
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    
    /** Повертає результат
     * @return поле {@linkplain MaxCommand#result}
     */
    public int getResult() {
        return result;
    }
    
    /** Перевіряє результат на готовність
     * @return false - результат не знайдено, true – знайдено
     * @see MaxCommand#result
     */
    public boolean running() {
        return progress < 100;
    }
    
    /** Використовується обробнком потока {@linkplain CommandQueue};
     * шаблон Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            if(viewResult.getItems().get(result).getSCells() < viewResult.getItems().get(idx).getSCells()){
                result = idx;
            }
            progress = idx * 100 / size;
            if(idx % (size / 3) == 0){
                System.out.println("Max " + progress + "%");
            }
            try{
                TimeUnit.MILLISECONDS.sleep(3000/ size);
            } catch (InterruptedException e){
                System.err.println(e);
            }
        }
        System.out.println("Max done. Item #" + result + " found: " + viewResult.getItems().get(result));
        progress = 100;
    }
}
