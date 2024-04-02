package Task3;

import java.io.IOException;
/** Product
 * шаблон проектування Factory Method
 * Інтерфейс об'єктів, що "фабрикуються"
 * Оголошує методи показу об'єктів
 * @author Яценко Віталій
 */
public interface View {
    
    /** Відображає заголовок */
    public void viewHeader();
    
    /** Відображає основну частину */
    public void viewBody();
    
    /** Відображає футер */
    public void viewFooter();
    
    /** Відображає цілісний об'єкт повністю */
    public void viewShow();
    
    /** Виконує ініціалізацію */
    public void viewInit();
    
    /** Зберігає дані для їх подальшого відновлення
     * @throws java.io.IOException */
    public void viewSave() throws IOException;
    
    /** Відновлює дані з збережених
     * @throws java.lang.Exception*/
    public void viewRestore() throws Exception;
}
