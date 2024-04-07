package Tests;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import Task3.ViewResult;
import Task6.AvgCommand;
import Task6.CommandQueue;
import Task6.MaxCommand;
import Task6.MinCommand;
import Task6.MinMaxCommand;


/**
 * Виконує тестування розроблених класів
 * 
 * @author Яценко Віталій
 * @see CommandQueue
 * @see MaxCommand
 * @see MinCommand
 * @see AvgCommand
 * @see MinMaxCommand
 */
public class MainTest {
    
    private final static int N = 1000;
    private static ViewResult view = new ViewResult(N);
    private static MaxCommand max1 = new MaxCommand(view); 
    private static MaxCommand max2 = new MaxCommand(view); 
    private static MinCommand min1 = new MinCommand(view); 
    private static MinCommand min2 = new MinCommand(view);
    private static AvgCommand avg1 = new AvgCommand(view); 
    private static AvgCommand avg2 = new AvgCommand(view); 
    private static MinMaxCommand minMax1 = new MinMaxCommand(view); 
    private static MinMaxCommand minMax2 = new MinMaxCommand(view); 
    private CommandQueue queue = new CommandQueue();
    
    /** Виконується першим */
    @BeforeClass
    public static void setUpBeforeClass(){
        view.viewInit();
        assertEquals(N, view.getItems().size());
    }
    
    /** Виконується останнім */
    @AfterClass
    public static void tearDownAfterClass(){
        assertEquals(max1.getResult(), max2.getResult());
        assertEquals(min1.getResult(), min2.getResult());
        assertEquals(avg1.getResult(), avg2.getResult());
        assertEquals(minMax1.getResultMax(), minMax2.getResultMax());
        assertEquals(minMax1.getResultMin(), minMax2.getResultMin());
    }
    
    /** Перевірка основного функціоналу класа {@linkplain MaxCommand} */
    @Test
    public void testMax(){
        max1.execute();
        assertTrue(max1.getResult() > -1);
    }
    
    /** Перевірка основного функціоналу класа {@linkplain MinCommand} */
    @Test
    public void testMin(){
        min1.execute();
        assertTrue(min1.getResult() > -1);
    }
    
    /** Перевірка основного функціоналу класа {@linkplain AvgCommand} */
    @Test
    public void testAvg(){
        avg1.execute();
        assertTrue(avg1.getResult() != 0);
    }
    
    /** Перевірка основного функціоналу класа {@linkplain MinMaxCommand} */
    @Test
    public void testMinMax(){
        minMax1.execute();
        assertTrue(minMax1.getResultMin() > -1);
    }
    
    /** Перевірка основного функціоналу класа
     * {@linkplain CommandQueue} з задачею {@linkplain MaxCommand}
     */
    @Test
    public void testMaxQueue(){
        queue.put(max2);
        try{
            while(max2.running()){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e){
            fail(e.toString());
        }
    }
    
    /** Перевірка основного функціоналу класа
     * {@linkplain CommandQueue} з задачею {@linkplain MinCommand}
     */
    @Test
    public void testMinQueue(){
        queue.put(min2);
        try{
            while(min2.running()){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e){
            fail(e.toString());
        }
    }
    
    /** Перевірка основного функціоналу класа
     * {@linkplain CommandQueue} з задачею {@linkplain AvgCommand}
     */
    @Test
    public void testAvgQueue(){
        queue.put(avg2);
        try{
            while(avg2.running()){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e){
            fail(e.toString());
        }
    }
    
    /** Перевірка основного функціоналу класа
     * {@linkplain CommandQueue} з задачею {@linkplain MinMaxCommand}
     */
      @Test
    public void testMinMaxQueue(){
        queue.put(minMax2);
        try{
            while(minMax2.running()){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e){
            fail(e.toString());
        }
    }
}
