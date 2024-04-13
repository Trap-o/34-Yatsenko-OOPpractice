package Task7;

import Task3.View;
import java.util.ArrayList;
import java.util.List;

/** Керування спостерігачами
 * Паттерн Observer
 * 
 * @author Яценко Віталій
 */
public class Subject implements Observable{
    
    /** Список спостерігачів */
    private List<Observer> observers = new ArrayList<>();
    
    /** Додавання спостерігача
     * Реалізація методу registerObserver
     * @param o – спостерігач
     */
    @Override
    public void registerObserver(Observer o){
        observers.add(o);
    }

    /** Видалення спостерігача
     * Реалізація методу registerObserver
     * @param o – спостерігач
     */
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    
    /** Надсилає повідомлення до всіх спостерігачів
     * Реалізація методу registerObserver
     * @param view – дані для спостерігачів
     */
    @Override
    public void notifyObservers(View view){
        for(var observer : observers){
            observer.update(view);
        }
    }
}
