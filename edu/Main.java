// Все классы в одном файле → один пакет

public class Main {
    public static void main(String[] args) {

        Base base = new Base();

        System.out.println(base.publicField);        // доступ есть
        System.out.println(base.defaultField);       // доступ есть (тот же пакет)
        System.out.println(base.protectedField);     // доступ есть (тот же пакет)
        // System.out.println(base.privateField);    // ОШИБКА — private недоступен

        base.publicMethod();                         // доступ есть
        base.defaultMethod();                        // доступ есть
        base.protectedMethod();                      // доступ есть
        // base.privateMethod();                     // ОШИБКА — private недоступен

        Derived d = new Derived();
        d.testAccess();                              // демонстрирует доступ наследника
    }
}


// Класс, у которого есть поля и методы с разными модификаторами
class Base {

    public int publicField = 1;
    int defaultField = 2;               // нет модификатора — default
    protected int protectedField = 3;
    private int privateField = 4;


    public void publicMethod() {
        System.out.println("public method");
    }

    void defaultMethod() {
        System.out.println("default method");
    }

    protected void protectedMethod() {
        System.out.println("protected method");
    }

    private void privateMethod() {
        System.out.println("private method");
    }
}


// Наследник — важен для демонстрации protected
class Derived extends Base {

    public void testAccess() {

        System.out.println(publicField);       // доступ есть
        System.out.println(defaultField);      // доступ есть (тот же пакет)
        System.out.println(protectedField);    // доступ есть (наследник)

        // System.out.println(privateField);   // ОШИБКА — private недоступен

        publicMethod();                        // доступ есть
        defaultMethod();                       // доступ есть
        protectedMethod();                     // доступ есть

        // privateMethod();                    // ОШИБКА — private недоступен
    }
}
