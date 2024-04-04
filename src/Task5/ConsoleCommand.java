package Task5;

/** Інтерфейс консольної команди;
* шаблон Command
* 
* @author Яценко Віталій
*/
public interface ConsoleCommand extends Command{
    
    /** Клавіша для запуску команди;
     * шаблон Command
     * @return символ клавіши
     */
    public char getKey();
}
