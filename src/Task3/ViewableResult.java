package Task3;

/** Concrete Creator
 * шаблон проектування Factory Method
 * Метод, що "фабрикує" об'єкти
 * @author Яценко Віталій
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable{
    /** Створює відображуваний об'єкт {@linkplain ViewResult} */
    @Override
    public View getView(){
        return new ViewResult();
    }
}
