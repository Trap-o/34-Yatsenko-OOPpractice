package Task7;

import Task3.View;

/** Вивід повідомлення про зміни в консоль
 * Паттерн Observer
 *
 * @author Яценко Віталій
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(View view){
        System.out.println("Receive changes.");
    }
}
