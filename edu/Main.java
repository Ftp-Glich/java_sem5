import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        practice12();
        practice13();
        practice14();
    }

    static void practice12() {
        String str = " Hello, World! ";
        String str2 = "HELLO, WORLD!";
        String str3 = "Java Programming";

        // 1. length() - возвращает длину строки
        System.out.println("Длина строки: " + str.length());

        // 2. trim() - удаляет пробелы в начале и конце
        System.out.println("trim(): '" + str.trim() + "'");

        // 3. toUpperCase() и toLowerCase() - преобразование регистра
        System.out.println("toUpperCase(): " + str.toUpperCase());
        System.out.println("toLowerCase(): " + str.toLowerCase());

        // 4. equals() и equalsIgnoreCase() - сравнение строк
        System.out.println("equals(): " + str.trim().equals(str2));
        System.out.println("equalsIgnoreCase(): " + str.trim().equalsIgnoreCase(str2));

        // 5. substring() - извлечение подстроки
        System.out.println("substring(7, 12): " + str.trim().substring(7, 12));

        // 6. replace() - замена символов или подстрок
        System.out.println("replace('l', 'L'): " + str.replace('l', 'L'));

        // 7. split() - разделение строки на массив
        String[] parts = str3.split(" ");
        System.out.println("split(): " + parts[0] + " | " + parts[1]);

        // 8. contains() - проверка наличия подстроки
        System.out.println("contains('World'): " + str.contains("World"));

        // 9. startsWith() и endsWith() - проверка начала и конца
        System.out.println("startsWith('Hello'): " + str.trim().startsWith("Hello"));
        System.out.println("endsWith('!'): " + str.trim().endsWith("!"));

        // 10. charAt() и indexOf() - работа с символами
        System.out.println("charAt(4): " + str.trim().charAt(4));
        System.out.println("indexOf('W'): " + str.trim().indexOf('W'));
    }

    static void practice13() {
        // Простой StringJoiner с разделителем
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("Apple");
        sj1.add("Banana");
        sj1.add("Orange");
        System.out.println("Fruits: " + sj1.toString());

        // StringJoiner с префиксом и суффиксом
        StringJoiner sj2 = new StringJoiner(" | ", "[ ", " ]");
        sj2.add("John");
        sj2.add("Jane");
        sj2.add("Bob");
        System.out.println("Names: " + sj2.toString());

        // StringJoiner для объединения коллекций
        StringJoiner sj3 = new StringJoiner(" - ");
        String[] colors = {"Red", "Green", "Blue"};
        for (String color : colors) {
            sj3.add(color);
        }
        System.out.println("Colors: " + sj3.toString());

        // merge() - объединение двух StringJoiner
        StringJoiner sj4 = new StringJoiner(", ");
        sj4.add("One");
        sj4.add("Two");

        StringJoiner sj5 = new StringJoiner(", ");
        sj5.add("Three");
        sj5.add("Four");

        sj4.merge(sj5);
        System.out.println("Merged: " + sj4.toString());
    }

    static void practice14() {
        // Текст блоки позволяют удобно работать с многострочным текстом
        String html = """
            <html>
                <body>
                    <h1>Hello, World!</h1>
                    <p>This is a paragraph</p>
                </body>
            </html>
            """;
        System.out.println("HTML:\n" + html);

        String json = """
            {
                "name": "John Doe",
                "age": 30,
                "city": "New York"
            }
            """;
        System.out.println("JSON:\n" + json);

        String sql = """
            SELECT id, name, email
            FROM users
            WHERE age > 18
            AND status = 'active'
            ORDER BY name
            """;
        System.out.println("SQL:\n" + sql);

        // Форматирование в текст блоках
        String name = "Alice";
        int age = 25;
        String formatted = """
            User Information:
            - Name: %s
            - Age: %d
            - Status: %s
            """.formatted(name, age, "active");
        System.out.println("Formatted:\n" + formatted);
    }
}