package ex01;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** Содержит реализацию методов для вычисления и отображения результатов.
* @author xone
* @version 1.0
*/
public class Calculation {
/** Имя файла, используемое при сериализации. */
private static final String FNAME = "Item2d.bin";
/** Сохраняет результат вычислений. Объект класса {@linkplain Item2d} */
private Item2d result;
/** Инициализирует {@linkplain Calc#result} */
public Calc() {
result = new Item2d();
}
/** Установить значение {@linkplain Calc#result}
* @param result - новое значение ссылки на объект {@linkplain Item2d}
*/
public void setResult(Item2d result) {

13

this.result = result;
}
/** Получить значение {@linkplain Calc#result}
* @return текущее значение ссылки на объект {@linkplain Item2d}
*/
public Item2d getResult() {
return result;
}
/** Вычисляет значение функции.
* @param x - аргумент вычисляемой функции.
* @return результат вычисления функции.
*/
private double calc(double x) {
return Math.sin(x * Math.PI / 180);
}
/** Вычисляет значение функции и сохраняет
* результат в объекте {@linkplain Calc#result}
* @param x - аргумент вычисляемой функции.
*/
public double init(double x ) {
result.setX(x);
return result.setY(calc(x));
}
/** Выводит результат вычислений. */
public void show() {
System.out.println(result);
}
/** Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
* @throws IOException
*/
public void save() throws IOException {
ObjectOutputStream os = new ObjectOutputStream(new
FileOutputStream(FNAME));
os.writeObject(result);
os.flush();
os.close();
}
/** Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
* @throws Exception
*/
public void restore() throws Exception {
ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
result = (Item2d)is.readObject();
is.close();
}
}
