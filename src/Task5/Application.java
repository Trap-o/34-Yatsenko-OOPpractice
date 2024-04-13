package Task5;

import Task3.View;
import Task4.ViewableTable;

/** Формує та відображає меню
 * Реалізує шаблон Singleton
 * @author Яценко Віталій
 */
public class Application {
    
    /** Посилання на екземпляр класу Application; шаблон Singleton
     * @see Application
     */
    private static Application instance = new Application();
    
    /** Закритий конструктор; шаблон Singleton
     * @see Application
     */
    private Application(){}
    
    /** Повертає посилання на екземпляр класу Application; шаблон Singleton
     * @see Application
     */
    public static Application getInstance(){
        return instance;
    }
    
    /** Об'єкт, що реалізує інтерфейс {@linkplain View};
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d};
     * Ініціалізація за допомогою Factory Method
     */
    private View view = new ViewableTable().getView();
    
    /** Об'єкт класа {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();
    
    /** Обробка команд користувача
     * @see Application
     */
    public void run(){
        menu.add(new GenerateConcoleCommand(view));
        menu.add(new ViewConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.execute();
    }  
}
