package Task5;

import Task3.View;

/** Консольна команда undo
* шаблон Command
* 
* @author Яценко Віталій
*/
public class UndoConsoleCommand implements ConsoleCommand {

    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private final View view;
    
    /** Ініціалізує поле {@linkplain UndoConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public UndoConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'u';
    }
    
    @Override
    public String toString(){
        return "'u'ndo";
    }
    
    @Override
    public void execute(){
        UndoCommand cmd = new UndoCommand(view);
        System.out.println("Undo last command.");
        try{
            cmd.undo();
        } catch(Exception e){
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    } 
}
