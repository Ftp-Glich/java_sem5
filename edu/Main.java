public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
    }

    public static void practice1() {
        OverloadExample ex = new OverloadExample();
        ex.print(10);
        ex.print("text");
        ex.print(1.5);
    }

    public static void practice2() {
        /*
           Если тип возвращаемого значения у метода суперкласса и переопределённого метода
           в подклассе НЕ совпадает, то будет ошибка компиляции.
        */
        Parent p = new Parent();
        Child c = new Child();
        p.show();
        c.show();
    }

    public static void practice3() {
        /*
           Аннотация @Override помогает обнаружить ошибку, если метод в подклассе
           написан с опечаткой или с неправильными параметрами.
           Без @Override компилятор не поймёт, что вы хотели переопределить метод.
        */
        OverrideDemo d = new OverrideDemo();
        d.run();
    }
}



class OverloadExample {

    void print(int x) {
        System.out.println("int: " + x);
    }

    void print(String s) {
        System.out.println("String: " + s);
    }

    void print(double d) {
        System.out.println("double: " + d);
    }
}



class Parent {
    void show() {
        System.out.println("Parent show()");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child show()");
    }

    // Если бы попытались изменить возвращаемый тип:
    // String show() { return "err"; }  // ошибка компиляции
}



class Base {
    void work() {
        System.out.println("Base work()");
    }
}

class OverrideDemo extends Base {

    @Override
    void work() {   // правильно переопределён
        System.out.println("OverrideDemo work()");
    }

    void run() {
        work();
    }

    /*
       Если написать вот так:

       @Override
       void worrk() { }

       то будет ошибка компиляции — метод worrk() в родительском классе отсутствует.
       Благодаря @Override ошибка обнаруживается сразу.
    */
}
