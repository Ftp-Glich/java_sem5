import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.print("Пожалуйста, введите имя: ");
        System.out.flush();

        try {
            String name = readUtf8Line();

            if (name == null || name.trim().isEmpty()) {
                System.out.println("Привет! Незнакомец!");
            } else {
                System.out.println("Привет! " + name.trim() + "!");
            }

        } catch (IOException e) {
            System.err.println("Ошибка обработки ввода: " + e.getMessage());
        }
    }

    private static String readUtf8Line() throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int byteRead;
        boolean hasData = false;

        while ((byteRead = System.in.read()) != -1) {
            if (byteRead == '\n') {
                break;
            }
            if (byteRead != '\r') {
                byteStream.write(byteRead);
                hasData = true;
            }
        }

        return hasData ? byteStream.toString(StandardCharsets.UTF_8.name()) : "";
    }
}