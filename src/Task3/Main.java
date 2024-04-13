package Task3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Обрахунок та показ результатів <br>
 * Містить реалізацію статичного методу main()
 * @author Яценко Віталій
 * @see Main#main 
 */
public class Main {
    /** Об'єкт, що реалізує інтерфейс  {@linkplain View}
     * обслуговує колекцію об'єктів {@linkplain Task2.Item2d}
     */
    private View view;
    /** Ініціалізує поле {@linkplain Main#view view} */
    public Main(View view){
        this.view = view;
    }
    /** Показ меню */
    protected void menu(){
            String s = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            do{
                do{
                    System.out.println("\nEnter command");
                    System.out.print("'g'enerate, 'v'iew, 's'ave, 'r'estore, 'q'uit: ");
                    try{
                        s = in.readLine();
                    } catch(IOException e){
                        System.out.println("Error " + e);
                        System.exit(0);
                    }
                }while (s.length() != 1);
                switch (s.charAt(0)){
                    case 'v' -> {
                        System.out.println("\nView current.");
                        view.viewShow();
                    }
                    case 'g' -> {
                        System.out.println("\nGenerate random values.");
                        view.viewInit();
                        view.viewShow();
                    break;
                    }
                    case 's' -> {
                        System.out.println("\nSave current.");
                        try{
                            view.viewSave();
                        } catch(IOException e){
                            System.out.println("Serialization error " + e);
                        }
                        view.viewShow();
                    }
                    case 'r' -> {
                        System.out.println("\nRestore last saved.");
                        try{
                            view.viewRestore();
                        } catch(Exception e){
                            System.out.println("Serialization error " + e);
                        }
                        view.viewShow();
                    }
                    case 'q' -> System.out.println("\nExit...");
                    default -> System.out.println("Wrong command.");
                }
            }while(s.charAt(0) != 'q');
    }

    /** Виконується при запуску програми
    * Обраховується кількість клітин, що вижили на заданому циклі поділу після бінарного поділу
    * Результати обчислень виводяться на екран
    * Викликає метод {@linkplain Main#menu() menu()}
    * @param args - параметри запуску програми
    */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}