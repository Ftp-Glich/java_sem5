/**
 * Класс для демонстрации работы с Javadoc.
 * <p>
 * Этот класс показывает различные возможности Javadoc комментариев
 * и используется для обучения созданию документации.
 * </p>
 *
 * @author Егор
 * @version 1.0
 * @since 2024
 */
public class JavadocDemo {

    /**
     * Константа для приветственного сообщения.
     */
    public static final String DEFAULT_GREETING = "Привет";

    private String name;
    private int age;

    /**
     * Конструктор по умолчанию.
     * Создает объект с именем "Гость" и возрастом 0.
     */
    public JavadocDemo() {
        this.name = "Гость";
        this.age = 0;
    }

    /**
     * Конструктор с параметрами.
     *
     * @param name имя пользователя
     * @param age возраст пользователя
     * @throws IllegalArgumentException если возраст отрицательный
     */
    public JavadocDemo(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
        this.name = name;
        this.age = age;
    }

    /**
     * Возвращает персонализированное приветствие.
     * <p>
     * Пример использования:
     * <pre>
     * {@code
     * JavadocDemo demo = new JavadocDemo("Егор", 20);
     * String greeting = demo.getGreeting();
     * }
     * </pre>
     * </p>
     *
     * @return строка приветствия в формате "Привет, [имя]!"
     * @see #DEFAULT_GREETING
     */
    public String getGreeting() {
        return DEFAULT_GREETING + ", " + name + "!";
    }

    /**
     * Проверяет, является ли пользователь совершеннолетним.
     *
     * @param country страна для проверки возрастного ценза
     * @return true если возраст ≥ 18, иначе false
     * @deprecated Используйте {@link #isAdult(int)} с указанием возраста совершеннолетия
     */
    @Deprecated
    public boolean isAdult(String country) {
        return age >= 18;
    }

    /**
     * Проверяет, является ли пользователь совершеннолетним.
     *
     * @param adultAge возраст совершеннолетия в стране
     * @return true если возраст пользователя ≥ adultAge
     */
    public boolean isAdult(int adultAge) {
        return age >= adultAge;
    }

    /**
     * Основной метод для демонстрации работы класса.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        JavadocDemo demo = new JavadocDemo("Егор", 20);
        System.out.println(demo.getGreeting());
        System.out.println("Совершеннолетний: " + demo.isAdult(18));
    }
}