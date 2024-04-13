package Task6;

import Task5.Command;

/** Представляє методи для вкладення та вилучення задач обробником потоку
 * шаблон Worker Thread
 * @author Яценко Віталій
 */
public interface Queue {
    /** Додає нову задачу в чергу; шаблон Worker Thread
     * @param cmd – задача
     */
    void put(Command cmd);
    
    /** Прибирає задачу з черги; шаблон Worker Thread
     * @return задача, що прибирається
     */
    Command take();
}
