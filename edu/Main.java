import java.util.Formatter;
import java.util.Date;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) {
        practice17();
        practice18();
        practice19();
    }

    static void practice17() {
        // Использование Formatter с различными спецификаторами
        Formatter formatter = new Formatter();

        // %s - строковый спецификатор
        formatter.format("Строковое значение: %s%n", "Hello World");

        // %d - целочисленный спецификатор
        formatter.format("Целое число: %d%n", 42);

        // %f - дробное число
        formatter.format("Дробное число: %.2f%n", 3.14159);

        // %b - логическое значение
        formatter.format("Логическое значение: %b%n", true);

        // %c - символьный спецификатор
        formatter.format("Символ: %c%n", 'A');

        System.out.println(formatter.toString());
        formatter.close();

        // Альтернативный способ с String.format()
        String formatted = String.format(
                "Комбинированный пример: %s, %d, %.2f, %b, %c%n",
                "Text", 100, 2.71828, false, 'Z'
        );
        System.out.println(formatted);
    }

    static void practice18() {
        // Метод flush() используется для принудительной записи данных из буфера
        // Демонстрация с PrintWriter
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        printWriter.print("Данные в буфере");
        System.out.println("До flush(): " + stringWriter.toString()); // Пустая строка

        printWriter.flush(); // Принудительная запись из буфера
        System.out.println("После flush(): " + stringWriter.toString()); // Данные появятся

        printWriter.close();

        // Пример с Formatter
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        formatter.format("Форматированные данные: %d%n", 123);
        System.out.println("До flush(): " + sb.toString()); // Данные уже есть, т.к. StringBuilder

        formatter.flush(); // Для Formatter с потоком вывода flush важен
        formatter.close();
    }

    static void practice19() {
        Date currentDate = new Date();
        Formatter formatter = new Formatter();

        // %tH - часы (00-23)
        formatter.format("Текущий час: %tH%n", currentDate);

        // %tM - минуты
        formatter.format("Текущие минуты: %tM%n", currentDate);

        // %tS - секунды
        formatter.format("Текущие секунды: %tS%n", currentDate);

        // %tY - год (4 цифры)
        formatter.format("Текущий год: %tY%n", currentDate);

        // %tB - полное название месяца
        formatter.format("Текущий месяц: %tB%n", currentDate);

        System.out.println(formatter.toString());
        formatter.close();

        // Комбинированный формат даты и времени
        String dateTime = String.format(
                "Полная дата: %tH:%tM:%tS %td.%tm.%tY%n",
                currentDate, currentDate, currentDate, currentDate, currentDate, currentDate
        );
        System.out.println(dateTime);

        // Альтернативный синтаксис с индексом аргумента
        String indexed = String.format(
                "Дата: %1$tA, %1$td %1$tB %1$tY года%nВремя: %1$tH:%1$tM:%1$tS",
                currentDate
        );
        System.out.println(indexed);
    }
}