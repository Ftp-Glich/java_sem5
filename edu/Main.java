public class Main {

    public static void main(String[] args) {
        practice1();
    }

    static void practice1() {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Код ошибки: " + e.getErrorCode());
        }

        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Код ошибки: " + e.getErrorCode());
            e.printStackTrace();
        }

        try {
            processUserData(null);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка с причиной: " + e.getMessage());
            System.out.println("Исходная причина: " + e.getCause().getMessage());
        }
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть отрицательным", 1001);
        } else if (age < 18) {
            throw new InvalidAgeException("Возраст должен быть не менее 18 лет", 1002);
        }
        System.out.println("Возраст корректен: " + age);
    }

    static void processUserData(String data) throws InvalidAgeException {
        try {
            if (data == null) {
                throw new NullPointerException("Данные пользователя не могут быть null");
            }
        } catch (NullPointerException e) {
            throw new InvalidAgeException("Ошибка обработки данных пользователя", 1003, e);
        }
    }
}

// Собственный класс исключения
class InvalidAgeException extends Exception {
    private final int errorCode;

    // Конструктор без параметров
    public InvalidAgeException() {
        super("Некорректный возраст");
        this.errorCode = 1000;
    }

    // Конструктор с сообщением
    public InvalidAgeException(String message) {
        super(message);
        this.errorCode = 1000;
    }

    // Конструктор с сообщением и кодом ошибки
    public InvalidAgeException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Конструктор с сообщением и причиной
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = 1000;
    }

    // Конструктор с сообщением, кодом ошибки и причиной
    public InvalidAgeException(String message, int errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}