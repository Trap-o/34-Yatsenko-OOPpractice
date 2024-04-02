package Tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import Task2.Item2d;
import Task3.ViewResult;
import java.util.Random;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Виконує тестування розроблених класів
 * 
 * @author Яценко Віталій
 */
public class MainTest {
    /** Перевірка основного функціоналу класу {@linkplain viewResult}*/
    @Test
    public void testCalc(){
        ViewResult view = new ViewResult(3);
        
        assertEquals(0, view.calc(0, 0));
        assertEquals(1000, view.calc(1000, 0));
        assertTrue(view.calc(1000, 0) != 10000);
//        view.init(0, 0);
//        Item2d item = new Item2d();
//        int ctr = 0;
//        
//        item.setCyclesAndPSCells(0, 0, 0);
//        assertTrue("Expected: <" + item + "> but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr).equals(item));
//        ctr++;
//        item.setCyclesAndPSCells(1000, 0, 1000);
//        assertTrue("Expected:<" + item + ">but was:<" + view.getItems().get(ctr) + ">", view.getItems().get(ctr).equals(item));
//        ctr++;
//        item.setCyclesAndPSCells(10000, 0, 1);
//        assertNotEquals(10000, view.getItems().get(ctr).getSCells());
    }
    /** Перевірка серіалізації, коректності відновлених даних*/
    @Test
    public void testRestore(){
        Random random = new Random();
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
        
        view1.init(random.nextInt(10001), random.nextInt(5));
        try{
            view1.viewSave();
        } catch (IOException e){
            Assert.fail(e.getMessage());
        }
        
        try{
            view2.viewRestore();
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }
        
        assertEquals(view1.getItems().size(), view2.getItems().size());
    }
}
