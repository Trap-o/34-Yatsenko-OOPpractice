package Task4;

import Task3.View;

/** Обрахунок та показ результатів <br>
 * Містить реалізацію статичного методу main()
 * 
 * @author Яценко Віталій
 * @see Main#main 
 */
public class Main extends Task3.Main {

    /** Ініціалізує поле {@linkplain Task3.Main#view view} */
    public Main(View view){
        super(view);
    }
    
    /** Виконується при запуску програми
    * Викликає метод {@linkplain Task3.Main#menu() menu()}
    * @param args - параметри запуску програми
    */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
