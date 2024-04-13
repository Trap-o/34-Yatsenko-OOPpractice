package Task5;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import java.util.Random;

/** Консольна команда Change item;
* шаблон Command
* @author Яценко Віталій
*/
public class ChangeConsoleCommand extends ChangeItemCommand implements ConsoleCommand {
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view;
    
    /** Повертає поле {@linkplain ChangeConsoleCommand#view}
     * @return значення {@linkplain ChangeConsoleCommand#view}
     */
    public View getView(){
        return view;
    }
    
    /** Встановлює поле {@linkplain ChangeConsoleCommand#view}
     * @param view значення для {@linkplain ChangeConsoleCommand#view}
     * @return нове значення {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view){
        return this.view = view;
    }
    
    /** Ініціалізує поле {@linkplain ChangeConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public ChangeConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'c';
    }
    
    @Override
    public String toString(){
        return "'c'hange";
    }
    
    public void execute(){
        Random random = new Random();
        System.out.println("Change item: scale factor " + setOffset(random.nextInt(3) + 1));
        for(Item2d item : ((ViewResult)view).getItems()){
            if(item.getPCells() > 300000){
                System.out.println("Maximum amount of cells");
                break;
            }
            else{
                super.setItem(item);
                super.execute();
            }
        }
        view.viewShow();
    }
}
