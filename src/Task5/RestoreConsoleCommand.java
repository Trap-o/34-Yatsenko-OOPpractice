package Task5;

import Task3.View;

/** Консольна команда restore
* шаблон Command
* 
* @author Яценко Віталій
*/
public class RestoreConsoleCommand implements ConsoleCommand{
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view;
    
    /** Ініціалізує поле {@linkplain RestoreConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public RestoreConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'r';
    }
    
    @Override
    public String toString(){
        return "'r'estore";
    }
    
    public void execute(){
        System.out.println("Restore last saved");
        try{
            view.viewRestore();
        } catch (Exception e){
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    } 
}
