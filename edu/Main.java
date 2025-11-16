public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
    }

    public static void practice1() {
        // Практика #1
        // this используется для обращения к полям и методам текущего объекта
        // super используется для обращения к полям и методам суперкласса

        SubClass obj = new SubClass(10);
        obj.printValues();
    }

    public static void practice2() {
        // Практика #2
        /*
           В наследовании:
           - private элементы суперкласса недоступны в подклассе
           - элементы без спецификатора доступны в пределах пакета (A -> B -> C, если они в одном пакете — доступны)
           - protected доступны в подклассах даже из других пакетов
           - public доступны всегда

           На примере:
           a1 (без спецификатора) — доступен в B и C, если классы в том же пакете
           a2 (public) — виден всем
           a3 (protected) — доступен в B и C
           a4 (private) — недоступен в B и C

           Аналогично с методами method1..method4
        */
        B b = new B();
        b.testAccess();
    }
}

class SuperClass {
    int value;

    SuperClass(int value) {
        this.value = value;
    }
}

class SubClass extends SuperClass {

    int value;

    SubClass(int value) {
        super(value);      // обращение к полю суперкласса
        this.value = value + 5; // обращение к полю текущего класса
    }

    void printValues() {
        System.out.println("super.value = " + super.value);
        System.out.println("this.value = " + this.value);
    }
}

class A {

    int a1;
    public int a2;
    protected int a3;
    private int a4;

    void method1() {}
    public void method2() {}
    protected void method3() {}
    private void method4() {}
}

class B extends A {

    void testAccess() {
        a1 = 1;   // доступно
        a2 = 2;   // доступно
        a3 = 3;   // доступно
        // a4 = 4; // недоступно — private
    }
}

class C extends B {

    void test2() {
        a1 = 10;
        a2 = 20;
        a3 = 30;
        // a4 = 40; // недоступно — private в A
    }
}
