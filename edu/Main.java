public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
    }

    // Практика #1: Спецификаторы доступа внутренних классов
    static void practice1() {
        // Public внутренний класс - доступен извне
        OuterClass1.InnerPublic innerPublic = new OuterClass1().new InnerPublic();

        // InternalClass1.InnerPrivate недоступен извне
        // OuterClass1.InnerPrivate innerPrivate = new OuterClass1().new InnerPrivate(); // Ошибка компиляции

        // Protected внутренний класс доступен в том же пакете
        OuterClass1.InnerProtected innerProtected = new OuterClass1().new InnerProtected();

        // Package-private внутренний класс доступен в том же пакете
        OuterClass1.InnerPackagePrivate innerPackagePrivate = new OuterClass1().new InnerPackagePrivate();
    }

    // Практика #2: Доступ внутреннего класса к внешнему
    static void practice2() {
        OuterClass2 outer = new OuterClass2();
        OuterClass2.InnerClass inner = outer.new InnerClass();
        inner.accessOuter();
    }

    // Практика #3: Доступ внешнего класса к внутреннему
    static void practice3() {
        OuterClass3 outer = new OuterClass3();
        outer.accessInner();
    }
}

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
            // Внутренний класс имеет доступ ко всем полям внешнего класса
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

        // Внешний класс имеет доступ к private полям внутреннего класса
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