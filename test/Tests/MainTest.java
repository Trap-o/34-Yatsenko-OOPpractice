package Tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import Task2.Item2d;
import Task3.ViewResult;
import Task5.ChangeConsoleCommand;
import Task5.ChangeItemCommand;
import java.util.Random;


/**
 * Виконує тестування розроблених класів
 * 
 * @author Яценко Віталій
 */
public class MainTest {
    /** Перевірка основного функціоналу методу {@linkplain ChangeItemCommand#execute()} */
    @Test
    public void testExecute(){
        
        Random random = new Random();
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        int primaryCells, cycles, survivingCells, offset;
        for(int ctr = 0; ctr < 1000; ctr++){
            cmd.getItem().setCyclesAndPSCells(primaryCells = random.nextInt(1001), cycles = random.nextInt(1001), survivingCells = random.nextInt(1001));
            cmd.setOffset(offset = random.nextInt(1001));
            cmd.execute();
            assertEquals(primaryCells, cmd.getItem().getPCells());
            assertEquals(cycles, cmd.getItem().getCycles());
            assertEquals(survivingCells * offset, cmd.getItem().getSCells());
        }
    }
    
    /** Перевірка класа {@linkplain ChangeConsoleCommand} */
    @Test
    public void testChangeConsoleCommand(){
        
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }
}
