public class Main {

    public static void main(String[] args) {
        practice5();
        practice6();
        practice7();
        practice8();
    }

    static void practice5() {
        // Interface без модификатора имеет package-private область видимости
        // Доступен только в том же пакете
        TestInterface5 test = new TestInterface5() {
            public void method() {
                System.out.println("Реализация package-private интерфейса");
            }
        };
        test.method();
    }

    static void practice6() {
        // Public интерфейс доступен из любого пакета
        TestInterface6 test = new TestInterface6() {
            public void method() {
                System.out.println("Реализация public интерфейса");
            }
        };
        test.method();
    }

    static void practice7() {
        // Protected интерфейс не может быть объявлен на верхнем уровне
        // Только как вложенный в классе
        OuterClass7.NestedInterface test = new OuterClass7.NestedInterface() {
            public void method() {
                System.out.println("Реализация protected интерфейса");
            }
        };
        test.method();
    }

    // Практика #8: Область видимости private интерфейса
    static void practice8() {
        // Private интерфейс не может быть объявлен на верхнем уровне
        // Только как вложенный в классе и доступен только внутри этого класса
        OuterClass8 outer = new OuterClass8();
        outer.usePrivateInterface();
    }
}

// Package-private интерфейс (без модификатора)
interface TestInterface5 {
    void method();
}

// Public интерфейс
public interface TestInterface6 {
    void method();
}

// Класс с protected вложенным интерфейсом
class OuterClass7 {
    protected interface NestedInterface {
        void method();
    }
}

// Класс с private вложенным интерфейсом
class OuterClass8 {
    private interface PrivateInterface {
        void method();
    }

    public void usePrivateInterface() {
        // Private интерфейс может использоваться только внутри класса
        PrivateInterface test = new PrivateInterface() {
            public void method() {
                System.out.println("Реализация private интерфейса внутри класса");
            }
        };
        test.method();
    }
}

// Абстрактный класс, не реализующий все методы интерфейса
abstract class AbstractClass implements TestInterface6 {
    // Не реализуем method() из TestInterface6
    // Класс должен быть abstract
}