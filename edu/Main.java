import java.lang.annotation.*;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        practice9();
    }

    // Практика #9: Аннотации
    static void practice9() {
        // Демонстрация встроенных аннотаций
        MyClass obj = new MyClass();
        obj.oldMethod(); // Использование устаревшего метода
        obj.newMethod();

        // Демонстрация пользовательской аннотации
        Class<Base> clazz = Base.class;
        if (clazz.isAnnotationPresent(BaseAction.class)) {
            BaseAction action = clazz.getAnnotation(BaseAction.class);
            System.out.println("Уровень BaseAction: " + action.level());
        }

        Base base = new Base();
        base.doSomething();
    }
}

// Примеры использования встроенных аннотаций
class ParentClass {
    public void display() {
        System.out.println("Родительский метод");
    }
}

class MyClass extends ParentClass {
    @Override
    public void display() {
        System.out.println("Переопределенный метод");
    }

    @Deprecated
    public void oldMethod() {
        System.out.println("Устаревший метод");
    }

    @SuppressWarnings("unused")
    public void newMethod() {
        int unusedVariable = 10; // Предупреждение подавлено
        System.out.println("Новый метод");
    }
}

// Пользовательская аннотация
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface BaseAction {
    int level();
    String name() default "defaultName";
}

// Класс с пользовательской аннотацией
@BaseAction(level = 2, name = "TestClass")
class Base {
    public void doSomething() {
        // Получение информации об аннотации через рефлексию
        Class<?> clazz = this.getClass();
        BaseAction action = clazz.getAnnotation(BaseAction.class);
        if (action != null) {
            System.out.println("Уровень: " + action.level() + ", Имя: " + action.name());
        }
    }
}

// Аннотация с различными типами параметров
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String author();
    String date();
    int version() default 1;
    String[] tags() default {};
}

class AnotherClass {
    @MethodInfo(
            author = "John Doe",
            date = "2024-01-15",
            version = 2,
            tags = {"test", "example"}
    )
    public void annotatedMethod() {
        System.out.println("Метод с аннотацией");
    }
}