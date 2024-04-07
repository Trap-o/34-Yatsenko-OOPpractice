package Task6;

import java.util.concurrent.TimeUnit;
import Task3.View;
import Task3.ViewResult;
import Task5.ConsoleCommand;

/** Консольна команда Execute All Threads
* шаблон Command
* 
* @author Яценко Віталій
*/
public class ExecuteConsoleCommand implements ConsoleCommand{
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view; 
    
    /** Поверьає поле {@linkplain ExecuteConsoleCommand#view}
     * @return значення {@linkplain ExecuteConsoleCommand#view}
     */
    public View getView(){
        return view;
    }
    
    /** Встановлює поле {@linkplain ExecuteConsoleCommand#view}
     * @param view значення для {@linkplain ExecuteConsoleCommand#view}
     * @return нове значення {@linkplain ExecuteConsoleCommand#view}
     */
    public View setView(View view){
        return this.view = view;
    }
    
    /** Ініціалізує поле {@linkplain GenerateConsoleCommand#view}
     * @param view об'єкт, що реалізує інтерфейс {@linkplain View}
     */
    public ExecuteConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'e';
    }
    
    @Override
    public String toString(){
        return "'e'xecute";
    }
    
    public void execute(){
        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();
        
        MaxCommand maxCommand = new MaxCommand((ViewResult)view);
        MinCommand minCommand = new MinCommand((ViewResult)view);
        AvgCommand avgCommand = new AvgCommand((ViewResult)view);
        MinMaxCommand minMaxCommand = new MinMaxCommand((ViewResult)view);
        SelectionCommand selectionCommand = new SelectionCommand((ViewResult)view);
        System.out.println("Execute all threads...");
        
        queue1.put(minCommand);
        queue1.put(avgCommand);
        queue1.put(selectionCommand);
        queue2.put(maxCommand);
        queue2.put(minMaxCommand);
        
        try{
            while(avgCommand.running() || maxCommand.running() || minMaxCommand.running() || minCommand.running() || selectionCommand.running()){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            
            queue1.shutdown();
            queue2.shutdown();
            
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e){
            System.err.println(e);
        }
        System.out.println("\nAll done.\n");
    }
}
