public class Main {
    public static void main(String[] args) {

        // 1. Инициализация при объявлении
        A1 obj1 = new A1();
        System.out.println("A1 a = " + obj1.a);

        // 2. Инициализация через конструктор
        A2 obj2 = new A2(10);
        System.out.println("A2 a = " + obj2.a);

        // 3. Инициализация через нестатический блок инициализации
        A3 obj3 = new A3();
        System.out.println("A3 a = " + obj3.a);
    }
}

// Вариант 1 — инициализация при объявлении
class A1 {
    public final int a = 5;
}

// Вариант 2 — инициализация через конструктор
class A2 {
    public final int a;
    public A2(int value) {
        a = value;
    }
}

// Вариант 3 — инициализация через нестатический блок инициализации
class A3 {
    public final int a;
    {
        a = 20;
    }
}
