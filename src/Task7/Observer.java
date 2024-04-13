package Task7;

import Task3.View;

/** Інтерфейс для спостерігача
 * паттерн Observer
 *
 * @author Яценко Віталій
 */
public interface Observer {
    
    /** Оновлення спостерігачів
     * @param view – об'єкт, де відбувається відстеження змін
     */
    void update(View view);
}
