public class Main {

    public static void main(String[] args) {
        practice1();
    }

    public static void practice1() {
        // Создаем объекты
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);
        Person p3 = new Person("Bob", 30);

        // Проверка equals
        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false
    }
}

// Класс Person
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // Соглашения:
        // 1. Рефлексивность: x.equals(x) должно быть true
        // 2. Симметричность: x.equals(y) == y.equals(x)
        // 3. Транзитивность: если x.equals(y) и y.equals(z), то x.equals(z)
        // 4. Согласованность: результат не должен меняться со временем
        // 5. Сравнение с null должно вернуть false

        if (this == obj) return true;           // сравнение с самим собой
        if (obj == null) return false;          // проверка на null
        if (getClass() != obj.getClass()) return false; // проверка одинакового класса

        Person other = (Person) obj;            // безопасное приведение
        return this.age == other.age &&
                (this.name != null ? this.name.equals(other.name) : other.name == null);
    }
}
