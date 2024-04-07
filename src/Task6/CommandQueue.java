package Task6;

import java.util.Vector;
import Task5.Command;

/** Створює обробник потоку,
 * що виконує об'єкти з інтерфейсом Command
 * шаблон Worker Thread
 * @author Яценко Віталій
 * @see Command
 */
public class CommandQueue implements Queue{
    
    /** Черга задач */
    private Vector<Command> tasks;
    
    /** Позначка очікування */
    private boolean waiting;
    
    /** Позначка Завершення */
    private boolean shutdown;
    
    /** Встановлює позначку завершення */
    public void shutdown(){
        shutdown = true;
    }
    
    /** Ініціалізація {@linkplain CommandQueue#tasks}
     * {@linkplain CommandQueue#waiting}
     * {@linkplain CommandQueue#waiting};
     * створює поток для класу {@linkplain CommandQueue.Worker}
     */
    public CommandQueue(){
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }
    
    @Override
    public void put(Command r){
        tasks.add(r);
        if(waiting == true){
            synchronized (this) {
                notifyAll();
            }
        }
    }
    
    @Override
    public Command take(){
        if(tasks.isEmpty()){
            synchronized (this) {
                waiting = true;
                try{
                    wait();
                } catch (InterruptedException ie){
                    waiting = false;
                }
            }
        }
        return (Command)tasks.remove(0);
    }
    
    
    /** Обслуговує чергу задач
     * шаблон Worker Thread
     * 
     * @author Яценко Віталій
     * @see Runnable
     */
    private class Worker implements Runnable{
        
        /** Дістає з черги готові до виконання задачі
         * шаблон Worker Thread
         */
        public void run(){
            while(!shutdown){
                Command r = take();
                r.execute();
            }
        }
    }
    
    
}
