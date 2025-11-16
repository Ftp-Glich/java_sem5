public class Main {
    public static void main(String[] args) {

        A a = new A();

        Number[] num = { new Integer(1), 11, 1.11f, 11.11 };

        // цикл for
        // ВАЖНО: здесь переменная n имеет тип Number.
        // Выбор перегруженного метода производится на этапе компиляции
        // по типу ССЫЛКИ (Number), а не по фактическому типу объекта.
        for (Number n : num) {
            a.printNum(n);  // всегда вызывает printNum(Number n)
        }

        // прямые вызовы
        // Теперь компилятор видит точный тип аргумента
        // и подбирает наиболее подходящую перегрузку.
        a.printNum(new Integer(1));  // Integer → вызывает printNum(Integer)
        a.printNum(11);              // int     → вызывает printNum(int)
        a.printNum(1.11f);           // float   → вызывает printNum(Float)
        a.printNum(11.11);           // double  → нет точного метода → Number
    }
}

class A {

    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }

    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }

    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }

    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }
}
