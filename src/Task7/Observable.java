package Task7;

import Task3.View;

/** Інтерфейс для керування спостерігачами
 * паттерн Observer
 *
 * @author Яценко Віталій
 */
public interface Observable {
    
    /** Додавання спостерігача
     * @param o – спостерігач
     */
    void registerObserver(Observer o);
    
    /** Видалення спостерігача
     * @param o – спостерігач
     */
    void removeObserver(Observer o);
    
    /** Надсилає повідомлення до всіх спостерігачів
     * @param view – дані для спостерігачів
     */
    void notifyObservers(View view);
}
