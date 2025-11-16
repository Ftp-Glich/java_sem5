
public class Main {

    public static void main(String[] args) {
        Practice1();
        Practice2();
        Practice3();
        Practice4();
    }
    public static void Practice1() {
        Integer n1 = Integer.decode("10");    // десятичное число -> 10
        Integer n2 = Integer.decode("0x10");  // шестнадцатеричное -> 16
        Integer n3 = Integer.decode("0X1F");  // шестнадцатеричное -> 31
        Integer n4 = Integer.decode("#1A");   // шестнадцатеричное -> 26
        Integer n5 = Integer.decode("010");   // восьмеричное -> 8
        System.out.println(n1 + ", " + n2 + ", " + n3 + ", " + n4 + ", " + n5);
    }

    public static void Practice2() {

        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = Boolean.valueOf("FALSE");

        // автоупаковка
        Boolean b4 = true;

        // через parse (возвращает primitive)
        boolean p = Boolean.parseBoolean("true");
        Boolean b5 = p;

        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4 + " " + b5);
    }

    public static void Practice3() {
        Integer x = null;
        int y = x; // NPE
    }

    public static void Practice4() {

        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;

        System.out.println("a1==i1 " + (a1 == i1));
        System.out.println("b1==i1 " + (b1 == i1));
        System.out.println("a1==b1 " + (a1 == b1));
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;

        System.out.println("a2==i2 " + (a2 == i2));
        System.out.println("b2==i2 " + (b2 == i2));
        System.out.println("a2==b2 " + (a2 == b2));
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));
    }


}
