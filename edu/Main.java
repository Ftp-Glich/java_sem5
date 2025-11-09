public class Main {

    public static void main(String[] args) {
        System.out.println("=== Демонстрация всех заданий ===\n");

        demonstrateDataTypes();

        printNameInUnicode();

        demonstrateVariableScope();

        demonstrateStringConcatenation();

        demonstrateMixedTypeOperations();

        demonstrateNarrowingConversion();

        demonstrateByteConversion();

        demonstrateTypeInference();
    }

    public static void demonstrateDataTypes() {
        System.out.println("1. Примеры типов данных с нулевыми значениями:");

        byte byteValue = 0;
        short shortValue = 0;
        int intValue = 0;
        long longValue = 0L;
        float floatValue = 0.0f;
        double doubleValue = 0.0;
        char charValue = '\u0000';
        boolean booleanValue = false;

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: '" + charValue + "' (\\u0000)");
        System.out.println("boolean: " + booleanValue);

        String stringValue = null;
        Object objectValue = null;
        int[] arrayValue = null;

        System.out.println("String: " + stringValue);
        System.out.println("Object: " + objectValue);
        System.out.println("int[]: " + arrayValue);
        System.out.println();
    }

    public static void printNameInUnicode() {
        System.out.println("2. Имя в Unicode:");

        // Е = \u0415, г = \u0433, о = \u043E, р = \u0440
        char letter1 = '\u0415'; // Е
        char letter2 = '\u0433'; // г
        char letter3 = '\u043E'; // о
        char letter4 = '\u0440'; // р

        System.out.println("Моё имя: " + letter1 + letter2 + letter3 + letter4);
        System.out.println();
    }

    public static void demonstrateVariableScope() {
        System.out.println("3. Область видимости переменных:");

        int a = 1;
        {
            int b = 2;
            System.out.println("Внутри блока: a = " + a + ", b = " + b);
        }

        System.out.println("Код 'int c = a + b;' не скомпилируется,");
        System.out.println("так как переменная b объявлена внутри блока {}");
        System.out.println("и не видна за его пределами.");
        System.out.println();
    }

    public static void demonstrateStringConcatenation() {
        System.out.println("4. Перегруженный оператор + с String:");

        String text = "Результат: ";
        int number = 42;
        double decimal = 3.14;
        boolean flag = true;
        Object obj = new Object();

        String result1 = text + number;
        String result2 = text + decimal;
        String result3 = text + flag;
        String result4 = text + obj;

        System.out.println("String + int: " + result1);
        System.out.println("String + double: " + result2);
        System.out.println("String + boolean: " + result3);
        System.out.println("String + Object: " + result4);

        String combined = "Сумма: " + 5 + 3.5 + true;
        System.out.println("Смешанная конкатенация: " + combined);
        System.out.println();
    }

    public static void demonstrateMixedTypeOperations() {
        System.out.println("5. Арифметические операции с разными типами:");

        int intVal = 10;
        double doubleVal = 3.5;
        float floatVal = 2.5f;
        long longVal = 100L;

        double result1 = intVal + doubleVal;
        System.out.println("int + double = double: " + intVal + " + " + doubleVal + " = " + result1);

        float result2 = floatVal + longVal;
        System.out.println("float + long = float: " + floatVal + " + " + longVal + " = " + result2);

        byte b = 10;
        short s = 20;
        int result3 = b + s;
        System.out.println("byte + short = int: " + b + " + " + s + " = " + result3);

        char c = 'A';
        int result4 = c + intVal;
        System.out.println("char + int = int: '" + c + "' + " + intVal + " = " + result4);
        System.out.println();
    }

    public static void demonstrateNarrowingConversion() {
        System.out.println("6. Сужающее преобразование типов:");

        double doubleVal = 123.456;
        float floatVal = 456.789f;
        long longVal = 123456789L;
        int intVal = 12345;

        float fromDouble = (float) doubleVal;
        System.out.println("double → float: " + doubleVal + " → " + fromDouble);

        int fromFloat = (int) floatVal;
        System.out.println("float → int: " + floatVal + " → " + fromFloat);

        int fromLong = (int) longVal;
        System.out.println("long → int: " + longVal + " → " + fromLong);

        short fromInt = (short) intVal;
        System.out.println("int → short: " + intVal + " → " + fromInt);

        byte smallByte = (byte) 128;
        System.out.println("int → byte (переполнение): 128 → " + smallByte);
        System.out.println();
    }

    public static void demonstrateByteConversion() {
        System.out.println("7. Пример с byte преобразованием:");

        int a = 120;


        byte c = (byte)(a + 10);
        System.out.println("byte c = (byte)(a + 10); = " + c);

        // byte d = a + 1; // ошибка компиляции! Требуется явное приведение
        // System.out.println("byte d = a + 1; - не скомпилируется");

        System.out.println("Объяснение:");
        System.out.println("- Арифметические операции с byte/short всегда дают int результат");
        System.out.println("- Нельзя неявно присвоить int переменной типа byte");
        System.out.println("- Требуется явное приведение типа (byte)");
        System.out.println();
    }

    public static void demonstrateTypeInference() {
        System.out.println("8. Type inference с var:");

        var name = "Анна"; // String
        var age = 25;      // int
        var salary = 50000.0; // double
        var list = new java.util.ArrayList<String>(); // ArrayList<String>
        var numbers = new int[]{1, 2, 3}; // int[]

        System.out.println("var name = \"Анна\"; // тип: " + name.getClass().getSimpleName());
        System.out.println("var age = 25; // тип: int");
        System.out.println("var salary = 50000.0; // тип: double");
        System.out.println("var list = new ArrayList<String>(); // тип: " + list.getClass().getSimpleName());
        System.out.println("var numbers = new int[]{1, 2, 3}; // тип: int[]");

        System.out.println("\nПреимущества var:");
        System.out.println("- Уменьшает избыточность кода");
        System.out.println("- Упрощает чтение сложных generic типов");
        System.out.println("- Тип выводится на этапе компиляции, безопасность типов сохраняется");

        System.out.println("\nОграничения var:");
        System.out.println("- Нельзя использовать без инициализации: var x; // ошибка");
        System.out.println("- Нельзя использовать для null: var y = null; // ошибка");
        System.out.println("- Нельзя использовать в параметрах методов");
        System.out.println("- Нельзя использовать для полей класса");
    }
}