public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
    }

    // Практика #1 — тривиальные примеры бесконечных циклов while и do-while
    public static void practice1() {

        // while — условие всегда истинно
        while (true) {
            break; // добавлен break, чтобы программа не зависла
        }

        // do-while — условие всегда истинно
        do {
            break;
        } while (true);
    }

    // Практика #2 — пример break и continue
    public static void practice2() {

        for (int i = 0; i < 5; i++) {

            if (i == 2) {
                continue; // пропускает i = 2
            }

            if (i == 4) {
                break; // завершает цикл при i = 4
            }

            System.out.println("i = " + i);
        }
    }
}
