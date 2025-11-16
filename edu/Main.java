public class Main {
    public static void main(String[] args) {

        OverloadExample o = new OverloadExample();
        o.print();              // перегрузка
        o.print(10);
        o.print("Hello");

        Base b = new Base();
        b.show();               // метод базового класса

        Derived d = new Derived();
        d.show();               // переопределённый метод
    }
}


// Перегрузка методов (overloading)
class OverloadExample {

    void print() {
        System.out.println("print()");
    }

    void print(int a) {
        System.out.println("print(int): " + a);
    }

    void print(String s) {
        System.out.println("print(String): " + s);
    }
}


// Базовый класс для демонстрации переопределения
class Base {
    void show() {
        System.out.println("Base show()");
    }
}


// Переопределение методов (override)
class Derived extends Base {
    @Override
    void show() {
        System.out.println("Derived show()");
    }
}
