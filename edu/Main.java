public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
    }

    // Практика #1 — какие типы можно использовать в switch
    public static void practice1() {

        // byte
        byte b = 1;
        switch (b) {
            case 1: break;
        }

        // short
        short s = 2;
        switch (s) {
            case 2: break;
        }

        // char
        char c = 'a';
        switch (c) {
            case 'a': break;
        }

        // int
        int i = 10;
        switch (i) {
            case 10: break;
        }

        // enum
        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY: break;
        }

        // String
        String str = "hello";
        switch (str) {
            case "hello": break;
        }

        // Типы, разрешённые в switch:
        // byte, short, char, int, enum, String
        // Также их оболочки через автоупаковку: Byte, Short, Character, Integer
    }

    // Практика #2 — что происходит без break
    public static void practice2() {
        int value = 2;
        int i = 0;

        switch (value) {
            case 1:
                i = 1;
                break;

            case 2:
                i = 2;   // break НЕТ → выполнение продолжится в следующий case

            case 3:
                i = 3;   // этот код выполнится тоже
                break;
        }

        // При value = 2 результат будет i = 3
        System.out.println("i = " + i);
    }

    enum Day {
        MONDAY, TUESDAY
    }
}
