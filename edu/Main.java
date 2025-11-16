public class Main {

    public static void main(String[] args) {
        practice1();
        System.out.println("-------------");
        practice2();
    }

    public static void practice1() {
        System.out.println(Color.RED.getHex());
        System.out.println(Color.GREEN.getHex());
        System.out.println(Color.BLUE.getHex());
    }

    public static void practice2() {
        for (DayOfWeek d : DayOfWeek.values()) {
            // isWeekend() — пользовательский метод перечисления
            System.out.println(d + " — выходной: " + d.isWeekend());
        }
    }
}

enum Color {

    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    private final String hex;

    Color(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}

enum DayOfWeek {

    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true);

    private final boolean weekend;

    DayOfWeek(boolean weekend) {
        this.weekend = weekend;
    }

    public boolean isWeekend() {
        return weekend;
    }
}
