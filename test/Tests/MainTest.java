package Tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import Task2.Calc;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Trap
 */
public class MainTest {
    @Test
    public void testCalc(){
        Calc calc = new Calc();
        calc.init(0, 0);
        assertEquals(0, calc.getResult().getSCells());
        calc.init(1000, 0);
        assertEquals(1000, calc.getResult().getSCells());
        calc.init(10000, 1);
        assertTrue(calc.getResult().getSCells() != 10000);
    }
    
    @Test
    public void testRestore(){
        Calc calc = new Calc();
        int primaryCells, cycles, survivingCells;
        
        for(int ctr = 0; ctr < 1000; ctr++){
            primaryCells = 1000;
            cycles = 5;
            survivingCells = (int) calc.init(primaryCells, cycles);
            try{
                calc.save();
            } catch(IOException e){
                Assert.fail(e.getMessage());
            }
            calc.init(2000, 10);
            try{
                calc.restore();
            } catch(Exception e){
                Assert.fail(e.getMessage());
            }
            assertEquals(survivingCells, calc.getResult().getSCells());
            assertEquals(primaryCells, calc.getResult().getPCells());
            assertEquals(cycles ,calc.getResult().getCycles());
        }
    }
}
