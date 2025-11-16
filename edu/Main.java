public class Main {

    public static void main(String[] args) {
        practice20();
        practice21();
    }

    static void practice20() {
        // Throwable - базовый класс для всех исключений и ошибок
        // Error - системные ошибки, которые обычно не обрабатываются (OutOfMemoryError, StackOverflowError)
        // Exception - проверяемые исключения, которые должны обрабатываться (IOException, SQLException)
        // RuntimeException - непроверяемые исключения (NullPointerException, IllegalArgumentException)

        System.out.println("Классы исключений:");
        System.out.println("Throwable - базовый класс всех исключений и ошибок");
        System.out.println("Error - критичные ошибки виртуальной машины");
        System.out.println("Exception - проверяемые исключения");
        System.out.println("RuntimeException - непроверяемые исключения");
    }

    static void practice21() {
        // ArithmeticException - арифметическая ошибка
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException - выход за границы массива
        try {
            int[] arr = new int[5];
            arr[10] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // IllegalArgumentException - неверный аргумент
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        // ClassCastException - неверное приведение типов
        try {
            Object obj = "String";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }

        // NullPointerException - обращение к null ссылке
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }

        // Множественная обработка исключений
        try {
            riskyOperation();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Общая обработка: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Блок finally выполняется всегда");
        }
    }

    static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }

    static void riskyOperation() {
        // Может выбросить разные исключения
        if (Math.random() > 0.5) {
            throw new ArithmeticException("Арифметическая ошибка");
        } else {
            throw new NullPointerException("Null ссылка");
        }
    }
}