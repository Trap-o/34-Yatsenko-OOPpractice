package Task2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 *
 * @author Trap
 */
public class Calc {
    private static final String FNAME = "Item2d.bin";
    private Item2d result;
    
    public Calc (){
        result = new Item2d();
    }
    
    public void setResult(Item2d result){
        this.result = result;
    }
    
    public Item2d getResult(){
        return result;
    }
    
    private int calc(int primaryCells, int cycles){
        Random random = new Random();
        int survivingCells = primaryCells;
        
        final double MIN_FAVOURABLE_DEATHRATE = 0.1; final double MAX_FAVOURABLE_DEATHRATE = 0.5;
        final double MIN_UNFAVOURABLE_DEATHRATE = 0.5; final double MAX_UNFAVOURABLE_DEATHRATE = 0.9;
        
        double minDeathrate; double maxDeathrate;
        double deathrate; double survivalrate;
        
        boolean favourableConditions = random.nextInt(0, 10) % 2 == 0;
        for(int i = 1; i <= cycles;i++){
            if(favourableConditions) { minDeathrate = MIN_FAVOURABLE_DEATHRATE; maxDeathrate = MAX_FAVOURABLE_DEATHRATE; }
            else{ minDeathrate = MIN_UNFAVOURABLE_DEATHRATE; maxDeathrate = MAX_UNFAVOURABLE_DEATHRATE;}
            
            deathrate = random.nextDouble() * (maxDeathrate - minDeathrate) + minDeathrate;
            survivalrate = 1 - deathrate; 
            survivingCells *= survivalrate;
        }
        return survivingCells;
    }
    
    public double init(int primaryCells, int cycles){
        result.setPCells(primaryCells);
        result.setCycles(cycles);
        return result.setSCells(calc(primaryCells, cycles));
    }
    
    public void show(){
        System.out.println(result);
    }
    
    public void save() throws IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }
    
    public void restore() throws Exception{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}
