package Task6;

import java.util.concurrent.TimeUnit;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.Command;
import java.util.ArrayList;
/** Задача, що використовується обробником потоку
 * Знаходить елементи колекції з результатом >0 та копіює до нової колекції
 * шаблон Worker Thread
 * @author Яценко Віталій
 * @see Command
 * @see CommandQueue
 */
public class SelectionCommand implements Command {
    /** Колекція для зберігання виділених елементів */
    private ArrayList<Item2d> crit = new ArrayList<Item2d>();
    /** Зберігає результат обробки колекції */
    private int result = -1;
    /** Позначка готовності результату */
    private int progress = 0;
    /** Обслуговує колекцію об'єктів {@linkplain Task2.Item2d} */
    private ViewResult viewResult;
    /** Повертає поле {@linkplain SelectionCommand#viewResult}
     * @return значення {@linkplain SelectionCommand#viewResult}
     */
    public ViewResult getViewResult() { return viewResult; }
    /** Встановлює поле {@linkplain SelectionCommand#viewResult}
     * @param viewResult значення для {@linkplain SelectionCommand#viewResult}
     * @return нове значення {@linkplain SelectionCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) { return this.viewResult = viewResult; }
    /** Ініціалізує поле {@linkplain SelectionCommand#viewResult}
     * @param viewResult об'єкт класа {@linkplain ViewResult}
     */
    public SelectionCommand(ViewResult viewResult) { this.viewResult = viewResult; }
    /** Повертає результат
     * @return поле {@linkplain SelectionCommand#result}
     */
    public int getResult() { return result; }
    /** Перевіряє результат на готовність
     * @return false - результат не знайдено, true – знайдено
     */
    public boolean running() { return progress < 100; }
    /** Використовується обробнком потока {@linkplain CommandQueue}; шаблон Worker Thread */
    @Override
    public void execute(){
        progress = 0;
        System.out.println("Selection by criteria executed...");
        int size = viewResult.getItems().size(), idx = 0;
        for(Item2d item : viewResult.getItems()){
            if(item.getSCells() > 0)
                crit.add(item);
            idx++;
                progress = idx * 100 / size;
                if(idx % (size / 5) == 0)
                    System.out.println("Selection " + progress + "%");
                try{
                    TimeUnit.MILLISECONDS.sleep(5000 / size);
                } catch (InterruptedException e){
                    System.err.println(e);
                }
        }
        System.out.println("\nSelection done. List of result, where number of surviving cells > 0: ");
        for(Item2d el : crit){
            System.out.println(el);
        }
        progress = 100;
    }
}
