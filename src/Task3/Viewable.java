package Task3;

/** Creator
 * шаблон проектування Factory Method
 * Метод, що "фабрикує" об'єкти
 * @author Яценко Віталій
 * @see Viewable#getView() 
 */
public interface Viewable {
    
    /** Створює об'єкт, що реалізує {@linkplain View} */
    public View getView();
}
