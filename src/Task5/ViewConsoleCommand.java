package Task5;

import Task3.View;

/** Консольна команда view
* шаблон Command
* 
* @author Яценко Віталій
*/
public class ViewConsoleCommand implements ConsoleCommand {
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view;
    
    /** Ініціалізує поле {@linkplain ViewConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public ViewConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'v';
    }
    
    @Override
    public String toString(){
        return "'v'iew";
    }
    
    public void execute(){
        System.out.println("View current.");
        view.viewShow();
    } 
}
