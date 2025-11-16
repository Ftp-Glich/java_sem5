public class Main {

    public static void main(String[] args) {
        practice1();
    }

    static void practice1() {
        // Данный код не выполнится успешно из-за исключения в статическом блоке
        try {
            // Попытка использовать класс App вызовет загрузку класса и выполнение статического блока
            Class.forName("App");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс App не найден");
        } catch (ExceptionInInitializerError e) {
            System.out.println("Произошла ошибка в статическом блоке инициализации: " + e.getCause().getMessage());
        }
    }
}

// Код из задания с небольшими изменениями для демонстрации
class App {
    final static int START_COUNTER;

    static {
        START_COUNTER = Integer.parseInt("Y-"); // NumberFormatException
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}