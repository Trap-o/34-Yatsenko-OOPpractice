package Tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import Task2.Item2d;
import Task4.ViewTable;
import java.util.Random;


/**
 * Виконує тестування розроблених класів
 * 
 * @author Яценко Віталій
 */
public class MainTest {
    /** Перевірка основного функціоналу класу {@linkplain ViewTable}*/
    @Test
    public void testCalc(){
        
        ViewTable tbl = new ViewTable(10, 5);
        assertEquals(10, tbl.getWidth());
        assertEquals(5, tbl.getItems().size());
        
        tbl.init(50, 100, 3);
        Item2d item = new Item2d();
        item.setCyclesAndPSCells(0, 0, 0);
        assertEquals(0, tbl.calc(0, 0));
        assertEquals(1000, tbl.calc(1000, 0));
        assertTrue(tbl.calc(10000, 1) != 10000);
        
    }
    /** Перевірка серіалізації, коректності відновлених даних*/
    @Test
    public void testRestore(){
        Random random = new Random();
        ViewTable tbl1 = new ViewTable(10, 1000);
        ViewTable tbl2 = new ViewTable();
        
        tbl1.init(random.nextInt(10001), random.nextInt(5));
        try{
            tbl1.viewSave();
        } catch (IOException e){
            Assert.fail(e.getMessage());
        }
        
        try{
            tbl2.viewRestore();
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }
        
        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
    }
}
