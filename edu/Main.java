public class Main {
    public static void main(String[] args) {

        // 1 — вызов через имя класса (правильный и рекомендованный способ)
        A.printVars();

        // 2 — вызов через объект (разрешено, но не рекомендуется)
        A obj = new A();
        obj.printVars();

        // 3 — анонимный объект
        new A().printVars();

        // 4 — импорт статического метода (если бы был другой файл)
        // можно было бы вызвать просто printVars();
    }
}

class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}
