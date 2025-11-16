/**
 * Программа для демонстрации операторов Java и оператора instanceof
 *
 * @author Егор
 * @version 1.0
 */
public class JavaOperatorsDemo {

    public static void main(String[] args) {
        System.out.println("=== Практика #1: Операторы Java ===\n");
        demonstrateOperators();

        System.out.println("\n=== Практика #2: Оператор instanceof ===\n");
        demonstrateInstanceof();
    }

    /**
     * Практика #1: Демонстрация всех операторов Java
     */
    public static void demonstrateOperators() {
        System.out.println("1. Арифметические операторы:");
        demonstrateArithmeticOperators();

        System.out.println("\n2. Операторы инкремента и декремента:");
        demonstrateIncrementDecrement();

        System.out.println("\n3. Операторы сравнения:");
        demonstrateComparisonOperators();

        System.out.println("\n4. Логические операторы:");
        demonstrateLogicalOperators();

        System.out.println("\n5. Побитовые операторы:");
        demonstrateBitwiseOperators();

        System.out.println("\n6. Операторы присваивания:");
        demonstrateAssignmentOperators();

        System.out.println("\n7. Тернарный оператор:");
        demonstrateTernaryOperator();

        System.out.println("\n8. Операторы со строками:");
        demonstrateStringOperators();
    }

    /**
     * Арифметические операторы
     */
    public static void demonstrateArithmeticOperators() {
        int a = 15, b = 4;
        double x = 7.5, y = 2.5;

        System.out.println("Целые числа: a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));      // Сложение
        System.out.println("a - b = " + (a - b));      // Вычитание
        System.out.println("a * b = " + (a * b));      // Умножение
        System.out.println("a / b = " + (a / b));      // Деление (целочисленное)
        System.out.println("a % b = " + (a % b));      // Остаток от деления

        System.out.println("\nДробные числа: x = " + x + ", y = " + y);
        System.out.println("x + y = " + (x + y));
        System.out.println("x / y = " + (x / y));      // Деление (дробное)
    }

    /**
     * Операторы инкремента и декремента (префиксная и постфиксная форма)
     */
    public static void demonstrateIncrementDecrement() {
        int x = 5;
        int y = 5;

        System.out.println("Начальные значения: x = " + x + ", y = " + y);

        // Постфиксный инкремент
        System.out.println("x++ = " + (x++));  // Сначала используем, потом увеличиваем
        System.out.println("После x++: x = " + x);

        // Префиксный инкремент
        System.out.println("++y = " + (++y));  // Сначала увеличиваем, потом используем
        System.out.println("После ++y: y = " + y);

        // Сброс значений
        x = 10;
        y = 10;
        System.out.println("\nНовые значения: x = " + x + ", y = " + y);

        // Постфиксный декремент
        System.out.println("x-- = " + (x--));
        System.out.println("После x--: x = " + x);

        // Префиксный декремент
        System.out.println("--y = " + (--y));
        System.out.println("После --y: y = " + y);

        // Демонстрация разницы в выражениях
        int a = 5;
        int b = 5;
        int result1 = a++ * 2;  // 5 * 2 = 10, потом a становится 6
        int result2 = ++b * 2;  // b становится 6, потом 6 * 2 = 12

        System.out.println("\nРазница в выражениях:");
        System.out.println("int result1 = a++ * 2; // result1 = " + result1 + ", a = " + a);
        System.out.println("int result2 = ++b * 2; // result2 = " + result2 + ", b = " + b);
    }

    /**
     * Операторы сравнения
     */
    public static void demonstrateComparisonOperators() {
        int a = 10, b = 5, c = 10;

        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("a == c: " + (a == c));  // Равно
        System.out.println("a != b: " + (a != b));  // Не равно
        System.out.println("a > b: " + (a > b));    // Больше
        System.out.println("a < b: " + (a < b));    // Меньше
        System.out.println("a >= c: " + (a >= c));  // Больше или равно
        System.out.println("b <= a: " + (b <= a));  // Меньше или равно

        double x = 5.5;
        double y = 5.5;
        System.out.println("\nДробные числа: x = " + x + ", y = " + y);
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
    }

    /**
     * Логические операторы
     */
    public static void demonstrateLogicalOperators() {
        boolean p = true, q = false;

        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q: " + (p && q));  // Логическое И
        System.out.println("p || q: " + (p || q));  // Логическое ИЛИ
        System.out.println("!p: " + (!p));          // Логическое НЕ
        System.out.println("!q: " + (!q));

        // Короткое замыкание (short-circuit)
        System.out.println("\nКороткое замыкание:");
        int x = 5;
        boolean result1 = (x > 0) && (x++ < 10);  // Второе выражение выполняется
        System.out.println("После (x > 0) && (x++ < 10): x = " + x);

        x = 5;
        boolean result2 = (x < 0) && (x++ < 10);  // Второе выражение НЕ выполняется
        System.out.println("После (x < 0) && (x++ < 10): x = " + x);
    }

    /**
     * Побитовые операторы
     */
    public static void demonstrateBitwiseOperators() {
        int a = 5;  // 0101 в двоичной
        int b = 3;  // 0011 в двоичной

        System.out.println("a = " + a + " (двоичное: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (двоичное: " + Integer.toBinaryString(b) + ")");
        System.out.println("a & b: " + (a & b) + " (двоичное: " + Integer.toBinaryString(a & b) + ")");  // И
        System.out.println("a | b: " + (a | b) + " (двоичное: " + Integer.toBinaryString(a | b) + ")");  // ИЛИ
        System.out.println("a ^ b: " + (a ^ b) + " (двоичное: " + Integer.toBinaryString(a ^ b) + ")");  // Исключающее ИЛИ
        System.out.println("~a: " + (~a) + " (двоичное: " + Integer.toBinaryString(~a) + ")");           // Отрицание

        // Сдвиги
        System.out.println("a << 1: " + (a << 1) + " (двоичное: " + Integer.toBinaryString(a << 1) + ")");  // Сдвиг влево
        System.out.println("a >> 1: " + (a >> 1) + " (двоичное: " + Integer.toBinaryString(a >> 1) + ")");  // Сдвиг вправо
    }

    /**
     * Операторы присваивания
     */
    public static void demonstrateAssignmentOperators() {
        int a = 10;
        System.out.println("Исходное значение: a = " + a);

        a += 5;  // a = a + 5
        System.out.println("После a += 5: a = " + a);

        a -= 3;  // a = a - 3
        System.out.println("После a -= 3: a = " + a);

        a *= 2;  // a = a * 2
        System.out.println("После a *= 2: a = " + a);

        a /= 4;  // a = a / 4
        System.out.println("После a /= 4: a = " + a);

        a %= 3;  // a = a % 3
        System.out.println("После a %= 3: a = " + a);
    }

    /**
     * Тернарный оператор
     */
    public static void demonstrateTernaryOperator() {
        int age = 20;
        String status = (age >= 18) ? "совершеннолетний" : "несовершеннолетний";
        System.out.println("Возраст " + age + ": " + status);

        int number = -5;
        String sign = (number >= 0) ? "положительное" : "отрицательное";
        System.out.println("Число " + number + " - " + sign);

        // Вложенный тернарный оператор
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : "D";
        System.out.println("Балл " + score + " - оценка " + grade);
    }

    /**
     * Операторы со строками
     */
    public static void demonstrateStringOperators() {
        String str1 = "Hello";
        String str2 = "World";

        // Конкатенация
        System.out.println("str1 + str2 = " + (str1 + str2));
        System.out.println("str1 + \" \" + str2 = " + (str1 + " " + str2));

        int number = 42;
        double pi = 3.14159;
        boolean flag = true;

        System.out.println("Строка + число: " + str1 + number);
        System.out.println("Строка + дробное: " + str1 + pi);
        System.out.println("Строка + boolean: " + str1 + flag);

        // Сравнение строк
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println("\nСравнение строк:");
        System.out.println("s1 == s2: " + (s1 == s2));        // true (пул строк)
        System.out.println("s1 == s3: " + (s1 == s3));        // false (разные объекты)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (содержимое одинаковое)
    }

    /**
     * Практика #2: Демонстрация оператора instanceof
     */
    public static void demonstrateInstanceof() {
        Object obj1 = new String("Hello");
        Object obj2 = new Integer(42);
        Object obj3 = null;
        Object obj4 = new CustomClass();

        System.out.println("1. instanceof с ненулевыми объектами:");
        System.out.println("obj1 instanceof String: " + (obj1 instanceof String));
        System.out.println("obj1 instanceof Object: " + (obj1 instanceof Object));
        System.out.println("obj2 instanceof Integer: " + (obj2 instanceof Integer));
        System.out.println("obj2 instanceof Number: " + (obj2 instanceof Number));
        System.out.println("obj4 instanceof CustomClass: " + (obj4 instanceof CustomClass));
        System.out.println("obj4 instanceof Object: " + (obj4 instanceof Object));

        System.out.println("\n2. instanceof с несовместимыми типами:");
        System.out.println("obj1 instanceof Integer: " + (obj1 instanceof Integer));
        System.out.println("obj2 instanceof String: " + (obj2 instanceof String));

        System.out.println("\n3. instanceof с null-объектом:");
        System.out.println("obj3 instanceof String: " + (obj3 instanceof String));
        System.out.println("obj3 instanceof Object: " + (obj3 instanceof Object));
        System.out.println("obj3 instanceof Integer: " + (obj3 instanceof Integer));

        System.out.println("\n4. Практическое использование instanceof:");
        processObject(obj1);
        processObject(obj2);
        processObject(obj3);
        processObject(obj4);
        processObject("Тестовая строка");
        processObject(123);
    }

    /**
     * Метод для демонстрации практического использования instanceof
     */
    public static void processObject(Object obj) {
        System.out.print("Обработка объекта: ");

        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Это строка: \"" + str + "\", длина: " + str.length());
        } else if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            System.out.println("Это целое число: " + num + ", квадрат: " + (num * num));
        } else if (obj instanceof CustomClass) {
            CustomClass custom = (CustomClass) obj;
            System.out.println("Это объект CustomClass: " + custom.getName());
        } else if (obj == null) {
            System.out.println("Это null-объект");
        } else {
            System.out.println("Неизвестный тип: " + obj.getClass().getSimpleName());
        }
    }
}

/**
 * Вспомогательный класс для демонстрации instanceof
 */
class CustomClass {
    private String name = "CustomObject";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CustomClass{name='" + name + "'}";
    }
}