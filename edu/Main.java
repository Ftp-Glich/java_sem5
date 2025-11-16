public class Main {
    public static void main(String[] args) {
        // Создание объекта класса A с id = 100
        new A(100);
    }
}

class A {

    // 1. Первый нестатический блок (логический блок)
    {
        // На этом моменте поле id ещё не инициализировано явно → 0
        System.out.println("logic (1) id= " + this.id);
    }

    // 2. Статический блок
    static {
        // Вызывается один раз при загрузке класса
        System.out.println("static logic");
    }

    // 3. Инициализация поля
    private int id = 1;

    // 4. Конструктор
    public A(int id) {
        this.id = id;  // присваиваем значение из конструктора
        System.out.println("ctor id= " + id);
    }

    // 5. Второй нестатический блок
    {
        // На этом моменте поле id уже проинициализировано явно (id = 1)
        System.out.println("logic (2) id= " + id);
    }
}
