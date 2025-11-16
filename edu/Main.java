public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
    }

    static void practice1() {
        // Несколько исключений обрабатываются идентичным образом
        try {
            int random = (int) (Math.random() * 3);
            if (random == 0) {
                int[] arr = new int[1];
                arr[5] = 10; // ArrayIndexOutOfBoundsException
            } else if (random == 1) {
                String str = null;
                str.length(); // NullPointerException
            } else {
                int result = 10 / 0; // ArithmeticException
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | ArithmeticException e) {
            System.out.println("Обработка разных исключений одинаковым способом: " + e.getClass().getSimpleName());
        }
    }

    static void practice2() {
        // Исключения в иерархии Ex1 <|-- Ex2 <|-- Ex3
        try {
            throw new Ex3("Исключение Ex3");
        } catch (Ex3 e) {
            System.out.println("Поймано Ex3: " + e.getMessage());
        } catch (Ex2 e) {
            System.out.println("Поймано Ex2: " + e.getMessage());
        } catch (Ex1 e) {
            System.out.println("Поймано Ex1: " + e.getMessage());
        }

        // Неправильный порядок catch (компилятор не позволит)
        /*
        try {
            throw new Ex3("Исключение Ex3");
        } catch (Ex1 e) {  // Этот блок поймает все исключения иерархии
            System.out.println("Поймано Ex1: " + e.getMessage());
        } catch (Ex2 e) {  // Этот блок никогда не выполнится - ошибка компиляции
            System.out.println("Поймано Ex2: " + e.getMessage());
        }
        */
    }

    static void practice3() {
        // Использование final в catch
        try {
            String str = null;
            str.length();
        } catch (final NullPointerException e) {
            // final предотвращает переприсваивание переменной e
            // e = new NullPointerException(); // Ошибка компиляции
            System.out.println("Исключение перехвачено: " + e.getMessage());
        }

        // Вложенные try блоки
        try {
            try {
                int[] arr = new int[2];
                arr[5] = 10; // ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Внутренний catch: " + e.getMessage());
                throw new RuntimeException("Новое исключение из внутреннего catch", e);
            }
        } catch (RuntimeException e) {
            System.out.println("Внешний catch: " + e.getMessage());
            System.out.println("Причина: " + e.getCause().getMessage());
        }
    }
}

// Иерархия исключений для демонстрации
class Ex1 extends Exception {
    public Ex1(String message) { super(message); }
}

class Ex2 extends Ex1 {
    public Ex2(String message) { super(message); }
}

class Ex3 extends Ex2 {
    public Ex3(String message) { super(message); }
}