package Task5;

/** Обрахунок та показ результатів <br>
 * Містить реалізацію статичного методу main()
 * 
 * @author Яценко Віталій
 * @see Main#main 
 */
public class Main {

    /** Виконується при запуску програми
    * Викликає метод {@linkplain Application.run()}
    * @param args - параметри запуску програми
    */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}
