package Task6;

import Task3.View;
import Task3.ViewableResult;
import Task5.Menu;
import Task5.GenerateConcoleCommand;
import Task5.ViewConsoleCommand;
import Task5.ChangeConsoleCommand;
import Task5.SaveConsoleCommand;
import Task5.RestoreConsoleCommand;
import Task5.UndoConsoleCommand;

/** Обрахунок та показ результатів <br>
 * Містить реалізацію статичного методу main()
 * 
 * @author Яценко Віталій
 * @see Main#main 
 */
public class Main {
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d};
     * ініціалізується за допомогою Factory Method
     */
    private View view = new ViewableResult().getView();
    
    /** Об'єкт класа {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();
    
    /** Обробка команд користувача */
    public void run() {
        menu.add(new GenerateConcoleCommand(view));
        menu.add(new ViewConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }
    
    /** Виконується при запуску програми
     * @param args параметри запуску програми
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}

