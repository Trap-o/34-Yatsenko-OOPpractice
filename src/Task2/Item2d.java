package Task2;

import java.io.Serializable;

/**
 *
 * @author Trap
 */
public class Item2d implements Serializable{
    /**
     * @param args the command line arguments
     */
    private int primaryCells;
    private int cycles;
    private int survivingCells;
    
    private static final long serialVersionUID = 1L;
    
    public Item2d(){
        primaryCells = 0;
        cycles = 0;
        survivingCells = 0;
    }
    
    public Item2d(int primaryCells, int cycles, int survivingCells){
        this.primaryCells = primaryCells;
        this.cycles = cycles;
        this.survivingCells = survivingCells;
    }
    
    public int setPCells(int primaryCells){
        return this.primaryCells = primaryCells;
    }
    
    public int getPCells(){
        return primaryCells;
    }
    
    public int setCycles(int cycles){
        return this.cycles = cycles;
    }
    
    public int getCycles(){
        return cycles;
    }
    
    public int setSCells(int survivingCells){
        return this.survivingCells = survivingCells;
    }
    
    public int getSCells(){
        return survivingCells;
    }
    
    public Item2d setCyclesAndPSCells(int primaryCells, int cycles, int survivingCells){
        this.primaryCells = primaryCells;
        this.cycles = cycles;
        this.survivingCells = survivingCells;
        return this;
    }
    
    @Override
    public String toString() {
        return "Number of primary cells = " + primaryCells + ", number of cycles = " + cycles + ", number of surviving cells = " + survivingCells;
    }
}