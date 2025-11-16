public class Main {
    public static void main(String[] args) {

        A a = new A();

        a.print(1, 2, 3);            // вызывает print(int...)
        a.print("A", "B", "C");      // вызывает print(String...)
        a.print(10);                 // вызывает print(int...)
        a.print("Hello");            // вызывает print(String...)
    }
}

class A {

    // Перегрузка №1 — метод с переменным числом int
    public void print(int... nums) {
        System.out.println("print(int...):");
        for (int n : nums) {
            System.out.println(n);
        }
    }

    // Перегрузка №2 — метод с переменным числом String
    public void print(String... strs) {
        System.out.println("print(String...):");
        for (String s : strs) {
            System.out.println(s);
        }
    }
}
