public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
        practice4();
    }

    // Практика #4: Вложенные классы в интерфейсе
    static void practice4() {
        // Создание экземпляра вложенного класса из интерфейса
        MyInterface.NestedClass nested = new MyInterface.NestedClass();
        nested.printMessage();
    }

    // Остальные методы practice1, practice2, practice3 остаются без изменений
    static void practice1() {
        OuterClass1.InnerPublic innerPublic = new OuterClass1().new InnerPublic();
        OuterClass1.InnerProtected innerProtected = new OuterClass1().new InnerProtected();
        OuterClass1.InnerPackagePrivate innerPackagePrivate = new OuterClass1().new InnerPackagePrivate();
    }

    static void practice2() {
        OuterClass2 outer = new OuterClass2();
        OuterClass2.InnerClass inner = outer.new InnerClass();
        inner.accessOuter();
    }

    static void practice3() {
        OuterClass3 outer = new OuterClass3();
        outer.accessInner();
    }
}

// Интерфейс с вложенным классом
interface MyInterface {
    void interfaceMethod();

    class NestedClass {
        public void printMessage() {
            System.out.println("Метод вложенного класса в интерфейсе");
        }
    }
}

// Классы для предыдущих практик остаются без изменений
class OuterClass1 {
    public class InnerPublic {}
    private class InnerPrivate {}
    protected class InnerProtected {}
    class InnerPackagePrivate {}
}

class OuterClass2 {
    private String privateField = "private поле";
    String packageField = "package-private поле";
    protected String protectedField = "protected поле";
    public String publicField = "public поле";

    class InnerClass {
        void accessOuter() {
            System.out.println(privateField);
            System.out.println(packageField);
            System.out.println(protectedField);
            System.out.println(publicField);
        }
    }
}

class OuterClass3 {
    void accessInner() {
        InnerClass inner = new InnerClass();
        System.out.println(inner.privateField);
        System.out.println(inner.packageField);
        System.out.println(inner.protectedField);
        System.out.println(inner.publicField);
    }

    class InnerClass {
        private String privateField = "private поле внутреннего класса";
        String packageField = "package-private поле внутреннего класса";
        protected String protectedField = "protected поле внутреннего класса";
        public String publicField = "public поле внутреннего класса";
    }
}