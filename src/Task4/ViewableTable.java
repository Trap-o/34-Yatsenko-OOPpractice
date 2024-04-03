package Task4;

import Task3.ViewableResult;
import Task3.View;

/** Concrete Creator
 * шаблон проектування Factory Method
 * Метод, що "фабрикує" об'єкти
 * @author Яценко Віталій
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult{
    
    /** Створює відображуваний об'єкт {@linkplain ViewTable} */
    @Override
    public View getView(){
        return new ViewTable();
    }
}
