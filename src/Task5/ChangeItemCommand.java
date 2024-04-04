package Task5;

import Task2.Item2d;

/** Rоманда Change item;
* шаблон Command
* 
* @author Яценко Віталій
*/
public class ChangeItemCommand implements Command {
    
    /** Об'єкт, що опрацьовується; шаблон Command */
    private Item2d item;
    
    /** Параметр команди; шаблон Command */
    private int offset;
    
    /** Встановлює поле {@linkplain ChangeItemCommand#item}
     * @param item значення для {@linkplain ChangeItemCommand#item}
     * @return нове значення {@linkplain ChangeItemCommand#item}
     */
    public Item2d setItem(Item2d item){
        return this.item = item;
    }
    
    /** Повертає поле {@linkplain ChangeItemCommand#item}
     * @return значення {@linkplain ChangeItemCommand#item}
     */
    public Item2d getItem(){
        return item;
    }
    
    /** Встановлює поле {@linkplain ChangeItemCommand#offset}
     * @param offset значення для {@linkplain ChangeItemCommand#offset}
     * @return нове значення {@linkplain ChangeItemCommand#offset}
     */
    public int setOffset(int offset){
        return this.offset = offset;
    }
    
    /** Повертає поле {@linkplain ChangeItemCommand#offset}
     * @return значення {@linkplain ChangeItemCommand#offset}
     */
    public int getOffset(){
        return offset;
    }   
    
    @Override
    public void execute(){
        item.setSCells(item.getSCells() * offset);
    }
}
