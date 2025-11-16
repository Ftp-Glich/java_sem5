public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
    }

    public static void practice1() {
        // Практика #1: демонстрация всех трёх вариантов использования super
        C1 obj = new C1();
        obj.printAll();
    }

    public static void practice2() {
        // Практика #2
        /*
           Если переменная a и метод method() определены только в классе A,
           то при вызове method() у объекта C:
           - super.a вернёт поле a из A
           - super.method() вызовет метод method() из A
        */
        C2 obj = new C2();
        obj.method();
    }

    public static void practice3() {
        // Практика #3
        A3 a1 = new A3();
        A3 a2 = new A3(10);
        A3 a3 = new A3(10, 20);
        A3 a4 = new A3(10, 20, 30);
    }
}



class A1 {
    int a = 10;

    A1() {
        System.out.println("Constructor A1");
    }

    void show() {
        System.out.println("Method A1.show()");
    }
}

class B1 extends A1 {
    int a = 20;

    B1() {
        super(); // вызов конструктора суперкласса
    }

    void show() {
        System.out.println("Method B1.show()");
    }
}

class C1 extends B1 {

    int a = 30;

    C1() {
        super(); // обращение к конструктору суперкласса
    }

    void printAll() {
        System.out.println(super.a);   // доступ к полю суперкласса (берётся из B1 → если бы не было, то из A1)
        super.show();                  // вызов метода суперкласса
    }
}



class A2 {
    int a = 100;

    void method() {
        System.out.println("A2.method()");
    }
}

class B2 extends A2 {
}

class C2 extends B2 {

    void method() {
        int x = super.a;      // получим значение поля из A2
        System.out.println("super.a = " + x);
        super.method();       // вызов метода из A2
    }
}



class A3 {
    int a;
    int b;
    int c;
    int z;

    public A3() {
        this(0, 0, 0); // единственный первый вызов
    }

    public A3(int a) {
        this(a, 0, 0);
    }

    public A3(int a, int b) {
        this(a, b, 0);
    }

    public A3(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        z = 1;
    }
}
