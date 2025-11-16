import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        practice1();
    }

    static void practice1() {
        // Чтение данных из текстового файла с помощью Scanner
        try (Scanner fileScanner = new Scanner(new File("example.txt"))) {

            // Чтение файла построчно
            System.out.println("Содержимое файла построчно:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());

            // Создаем временный файл для демонстрации
            createDemoFile();
            readDemoFile();
        }
    }

    static void createDemoFile() {
        // Создаем демонстрационный файл
        try (java.io.FileWriter writer = new java.io.FileWriter("example.txt")) {
            writer.write("Hello World\n");
            writer.write("123 456 789\n");
            writer.write("3.14 2.71 1.41\n");
            writer.write("Java Scanner Example\n");
            writer.write("true false true\n");
        } catch (Exception e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }
    }

    static void readDemoFile() {
        System.out.println("\nДемонстрация различных методов Scanner:");

        try (Scanner scanner = new Scanner(new File("example.txt"))) {

            // Чтение разных типов данных
            String firstLine = scanner.nextLine();
            System.out.println("Первая строка: " + firstLine);

            // Чтение чисел
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            System.out.println("Числа: " + num1 + ", " + num2 + ", " + num3);

            scanner.nextLine(); // Переход на следующую строку

            // Чтение дробных чисел
            double d1 = scanner.nextDouble();
            double d2 = scanner.nextDouble();
            double d3 = scanner.nextDouble();
            System.out.println("Дробные числа: " + d1 + ", " + d2 + ", " + d3);

            scanner.nextLine(); // Переход на следующую строку

            // Чтение строки
            String textLine = scanner.nextLine();
            System.out.println("Текст: " + textLine);

            // Чтение логических значений
            boolean b1 = scanner.nextBoolean();
            boolean b2 = scanner.nextBoolean();
            boolean b3 = scanner.nextBoolean();
            System.out.println("Логические значения: " + b1 + ", " + b2 + ", " + b3);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        // Дополнительный пример с использованием разделителей
        System.out.println("\nЧтение с пользовательским разделителем:");
        String data = "apple,orange,banana,grape";
        try (Scanner scanner = new Scanner(data)) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                System.out.println("Фрукт: " + scanner.next());
            }
        }
    }
}