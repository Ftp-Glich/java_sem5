public class Main {

    public static void main(String[] args) {
        practice();
    }

    static void practice() {
        // Исключение, которое будет перехвачено
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Элемент массива: " + numbers[1]); // Успешно
            System.out.println("Элемент массива: " + numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        System.out.println("Программа продолжает работу после первого исключения");

        // Исключение, которое приведет к аварийной остановке
        String text = null;
        System.out.println("Длина строки: " + text.length()); // NullPointerException
    }

    // Дополнительный пример с передачей исключения вверх по стеку
    static void methodA() {
        methodB(); // Исключение передается вверх по стеку
    }

    static void methodB() {
        methodC(); // Исключение передается вверх по стеку
    }

    static void methodC() {
        // Исключение не перехватывается здесь
        int result = 10 / 0; // ArithmeticException
    }

    // Пример с объявлением throws
    static void riskyMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("Ошибка в аргументе");
    }

    static void handleRiskyMethod() {
        try {
            riskyMethod();
        } catch (IllegalArgumentException e) {
            System.out.println("Обработано: " + e.getMessage());
        }
    }
}