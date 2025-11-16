import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
        practice4();
    }

    static void practice1() {
        // Использование ByteArrayInputStream для демонстрации метода read()
        byte[] data = {65, 66, 67, 68, 69}; // Байты, соответствующие A, B, C, D, E
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                System.out.println("Прочитан байт: " + byteRead + " -> символ: " + (char) byteRead);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }

        // Демонстрация read(byte[] buffer)
        try (InputStream inputStream = new ByteArrayInputStream("Hello World".getBytes())) {
            byte[] buffer = new byte[5];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                System.out.println("Прочитано " + bytesRead + " байт: " + new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    static void practice2() {
        // Использование ByteArrayOutputStream для демонстрации метода write(int)
        try (OutputStream outputStream = new ByteArrayOutputStream()) {
            for (int i = 65; i < 70; i++) { // Байты A, B, C, D, E
                outputStream.write(i);
                System.out.println("Записан байт: " + i + " -> символ: " + (char) i);
            }

            String result = outputStream.toString();
            System.out.println("Результат в строке: " + result);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }

        // Демонстрация write(byte[] buffer)
        try (OutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] data = "Hello OutputStream".getBytes();
            outputStream.write(data);
            System.out.println("Записаны все байты: " + outputStream.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    static void practice3() {
        // Reader и Writer работают с символами (char), а не байтами
        // Они обеспечивают корректную обработку Unicode и кодировок

        String text = "Привет мир! Hello World! 中文测试";

        // Проблема с байтовыми потоками и Unicode
        try (OutputStream os = new FileOutputStream("test_bytes.txt")) {
            os.write(text.getBytes()); // Зависит от кодировки по умолчанию
        } catch (IOException e) {
            System.out.println("Ошибка байтового потока: " + e.getMessage());
        }

        // Правильное решение с символическими потоками
        try (Writer writer = new FileWriter("test_chars.txt", StandardCharsets.UTF_8)) {
            writer.write(text); // Корректная обработка Unicode
        } catch (IOException e) {
            System.out.println("Ошибка символьного потока: " + e.getMessage());
        }

        System.out.println("Reader/Writer обеспечивают:");
        System.out.println("- Корректную работу с Unicode");
        System.out.println("- Автоматическое преобразование кодировок");
        System.out.println("- Работу с символами, а не байтами");
        System.out.println("- Поддержку международных символов");
    }

    static void practice4() {
        // AutoCloseable позволяет использовать try-with-resources для автоматического закрытия ресурсов

        // Пример с пользовательским ресурсом
        try (MyResource resource = new MyResource()) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пример с несколькими ресурсами
        try (InputStream is = new ByteArrayInputStream("test".getBytes());
             OutputStream os = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}

// Пользовательский класс, реализующий AutoCloseable
class MyResource implements AutoCloseable {
    public void doSomething() {
        System.out.println("Выполняем полезную работу");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Ресурс автоматически закрыт");
        // Освобождение ресурсов: закрытие файлов, сетевых соединений и т.д.
    }
}