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
    private View view;
    
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
    
    public void execute(){
        System.out.println("Undo last command.");
        try{
            UndoCommand cmd = new UndoCommand(view);
            cmd.Undo();
        } catch(Exception e){
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    } 
}
