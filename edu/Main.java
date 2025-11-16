public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
    }

    public static void practice1() {
        /*
           В этом примере попытка переопределить final-метод showMessage()
           в классе B приведёт к ошибке компиляции.
        */
        A a = new A();
        a.showMessage();
    }

    public static void practice2() {
        /*
           В этом примере попытка унаследоваться от FinalClass
           приведёт к ошибке компиляции.
        */
        FinalClass f = new FinalClass();
        f.print();
    }
}


class A {

    public final void showMessage() {
        System.out.println("Final method in A");
    }
}

// Ошибка: нельзя переопределить final-метод
// class B extends A {
//     @Override
//     public void showMessage() {   // ошибка компиляции
//         System.out.println("Try to override");
//     }
// }



final class FinalClass {

    public void print() {
        System.out.println("Final class method");
    }
}

// Ошибка: final-класс нельзя наследовать
// class Child extends FinalClass { }  // ошибка компиляции
