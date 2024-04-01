package Task2;

import java.io.Serializable;

/**
 * Клас з серіалізацією, зберігає початкові дані та результат обчислень
 * 
 * @author Яценко Віталій
 */
public class Item2d implements Serializable{
    /**Аргумент обчислюваної функції */
    private int primaryCells;
    /**Аргумент обчислюваної функції */
    private int cycles;
    /**Результат обчислюваної функції */
    private int survivingCells;
    
    private static final long serialVersionUID = 1L;
    
    /**Ініціалізація {@linkplain Item2d#primaryCells}, @linkplain Item2d#cycles}, дефолтними значеннями */
    public Item2d(){
        primaryCells = 0;
        cycles = 0;
        survivingCells = 0;
    }
    /**Встановлює значення аргументу функції
     * @param primaryCells значення для ініціалізації поля
     * @param cycles значення для ініціалізації поля
     * @param survivingCells значення для ініціалізації поля
     */
    public Item2d(int primaryCells, int cycles, int survivingCells){
        this.primaryCells = primaryCells;
        this.cycles = cycles;
        this.survivingCells = survivingCells;
    }
    
    /**Встановлює значення {@linkplain Item2d#primaryCells}
     * @param primaryCells – значення для {@linkplain Item2d#primaryCells}
     * @return Значення {@linkplain Item2d#primaryCells}
     */
    public int setPCells(int primaryCells){
        return this.primaryCells = primaryCells;
    }
    
    /**Отримання значення поля {@linkplain Item2d#primaryCells}
     * @return Значення {@linkplain Item2d#primaryCells}
     */
    public int getPCells(){
        return primaryCells;
    }
    
    /**Встановлює значення {@linkplain Item2d#cycles}
     * @param cycles – значення для {@linkplain Item2d#cycles}
     * @return Значення {@linkplain Item2d#cycles}
     */
    public int setCycles(int cycles){
        return this.cycles = cycles;
    }
    
    /**Отримання значення поля {@linkplain Item2d#cycles}
     * @return Значення {@linkplain Item2d#cycles}
     */
    public int getCycles(){
        return cycles;
    }
    
    /**Встановлює значення {@linkplain Item2d#survivingCells}
     * @param survivingCells – значення для {@linkplain Item2d#survivingCells}
     * @return Значення {@linkplain Item2d#survivingCells}
     */
    public int setSCells(int survivingCells){
        return this.survivingCells = survivingCells;
    }
    
    /**Отримання значення поля {@linkplain Item2d#survivingCells}
     * @return Значення {@linkplain Item2d#survivingCells}
     */
    public int getSCells(){
        return survivingCells;
    }
    
    /** Встановлення значеннь {@linkplain Item2d#primaryCells}, {@linkplain Item2d#cycles} та {@linkplain Item2d#survivingCells}
    * @param primaryCells - значение для {@linkplain Item2d#primaryCells}
    * @param cycles - значение для {@linkplain Item2d#cycles}
    * @param survivingCells - значение для {@linkplain Item2d#survivingCells}
    * @return this
    */
    public Item2d setCyclesAndPSCells(int primaryCells, int cycles, int survivingCells){
        this.primaryCells = primaryCells;
        this.cycles = cycles;
        this.survivingCells = survivingCells;
        return this;
    }
    
    /** 
    * @return строку зі значеннями аргументів та результату
    */
    @Override
    public String toString() {
        return "Number of primary cells = " + primaryCells + ", number of cycles = " + cycles + ", number of surviving cells = " + survivingCells;
    }
}