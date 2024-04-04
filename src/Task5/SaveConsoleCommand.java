package Task5;

import java.io.IOException;
import Task3.View;

/** Консольна команда save
* шаблон Command
* 
* @author Яценко Віталій
*/
public class SaveConsoleCommand implements ConsoleCommand {
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view;
    
    /** Ініціалізує поле {@linkplain SaveConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public SaveConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 's';
    }
    
    @Override
    public String toString(){
        return "'s'ave";
    }
    
    public void execute(){
        System.out.println("Save current.");
        try{
            view.viewSave();
        } catch (IOException e){
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    } 
}
