package Task5;

import Task3.View;

/** Консольна команда generate
* шаблон Command
* 
* @author Яценко Віталій
*/
public class GenerateConcoleCommand implements ConsoleCommand {
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view; 
    
    /** Ініціалізує поле {@linkplain GenerateConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public GenerateConcoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'g';
    }
    
    @Override
    public String toString(){
        return "'g'enerate";
    }
    
    public void execute(){
        System.out.println("Random generation");
        view.viewInit();
        view.viewShow();
    }
}
