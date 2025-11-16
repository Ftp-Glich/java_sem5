public class Main {

    public static void main(String[] args) {
        practice10();
        practice11();
    }

    // Практика #10: Default и статические методы в интерфейсах
    static void practice10() {
        MyInterface obj = new MyClass();

        // Вызов default метода через объект класса
        obj.defaultMethod();

        // Вызов переопределенного default метода
        obj.overriddenDefaultMethod();

        // Вызов статического метода через интерфейс
        MyInterface.staticMethod();

        // Вызов абстрактного метода
        obj.abstractMethod();
    }

    // Практика #11: Конфликт default методов
    static void practice11() {
        MyClassWithConflict obj = new MyClassWithConflict();
        obj.conflictingMethod();

        MyClassWithExplicit obj2 = new MyClassWithExplicit();
        obj2.conflictingMethod();
    }
}

// Практика #10: Интерфейс с default и статическими методами
interface MyInterface {
    // Абстрактный метод (по умолчанию public abstract)
    void abstractMethod();

    // Default метод
    default void defaultMethod() {
        System.out.println("Default метод в интерфейсе");
    }

    // Еще один default метод для демонстрации переопределения
    default void overriddenDefaultMethod() {
        System.out.println("Default метод, который будет переопределен");
    }

    // Статический метод
    static void staticMethod() {
        System.out.println("Статический метод в интерфейсе");
    }
}

// Класс, реализующий интерфейс
class MyClass implements MyInterface {
    @Override
    public void abstractMethod() {
        System.out.println("Реализация абстрактного метода");
    }

    @Override
    public void overriddenDefaultMethod() {
        System.out.println("Переопределенный default метод в классе");
    }
}

// Практика #11: Интерфейсы с конфликтующими default методами
interface InterfaceA {
    default void conflictingMethod() {
        System.out.println("Default метод из InterfaceA");
    }
}

interface InterfaceB {
    default void conflictingMethod() {
        System.out.println("Default метод из InterfaceB");
    }
}

// Класс, реализующий оба интерфейса - требует разрешения конфликта
class MyClassWithConflict implements InterfaceA, InterfaceB {
    // Компилятор требует явного разрешения конфликта методов
    @Override
    public void conflictingMethod() {
        // Можно выбрать одну из реализаций
        InterfaceA.super.conflictingMethod();
        // Или предоставить свою
        System.out.println("Собственная реализация в классе");
    }
}

// Альтернативный способ разрешения конфликта
class MyClassWithExplicit implements InterfaceA, InterfaceB {
    @Override
    public void conflictingMethod() {
        // Явное указание, метод какого интерфейса использовать
        InterfaceB.super.conflictingMethod();
    }
}

// Интерфейс с private методами (Java 9+)
interface AdvancedInterface {
    default void complexMethod() {
        helperMethod();
        staticHelper();
    }

    private void helperMethod() {
        System.out.println("Private метод-помощник");
    }

    private static void staticHelper() {
        System.out.println("Private static метод-помощник");
    }
}