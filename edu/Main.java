public class Main {

    public static void main(String[] args) {
        practice15();
        practice16();
    }

    static void practice15() {
        // Создание объектов
        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sbf = new StringBuffer("World");

        // 1. append() - добавление в конец
        sb.append(" Java");
        sbf.append(" Programming");
        System.out.println("append(): " + sb + " | " + sbf);

        // 2. insert() - вставка в указанную позицию
        sb.insert(5, ", ");
        sbf.insert(5, ", ");
        System.out.println("insert(): " + sb + " | " + sbf);

        // 3. delete() - удаление части строки
        sb.delete(5, 7);
        sbf.delete(5, 7);
        System.out.println("delete(): " + sb + " | " + sbf);

        // 4. deleteCharAt() - удаление одного символа
        sb.deleteCharAt(4);
        sbf.deleteCharAt(4);
        System.out.println("deleteCharAt(): " + sb + " | " + sbf);

        // 5. replace() - замена части строки
        sb.replace(0, 5, "Hi");
        sbf.replace(0, 5, "Java");
        System.out.println("replace(): " + sb + " | " + sbf);

        // 6. reverse() - обратный порядок символов
        sb.reverse();
        sbf.reverse();
        System.out.println("reverse(): " + sb + " | " + sbf);

        // Возвращаем обратно для следующих операций
        sb.reverse();
        sbf.reverse();

        // 7. capacity() - текущая емкость буфера
        System.out.println("capacity(): " + sb.capacity() + " | " + sbf.capacity());

        // 8. length() - текущая длина
        System.out.println("length(): " + sb.length() + " | " + sbf.length());

        // 9. setLength() - установка новой длины
        sb.setLength(3);
        sbf.setLength(4);
        System.out.println("setLength(): " + sb + " | " + sbf);

        // 10. charAt() и setCharAt() - доступ к символам
        sb.setCharAt(1, 'a');
        sbf.setCharAt(1, 'a');
        System.out.println("setCharAt(): " + sb + " | " + sbf);
        System.out.println("charAt(0): " + sb.charAt(0) + " | " + sbf.charAt(0));

        // Дополнительные полезные методы
        StringBuilder sb2 = new StringBuilder("Test");
        // indexOf() - поиск подстроки
        System.out.println("indexOf('es'): " + sb2.indexOf("es"));
        // substring() - извлечение подстроки
        System.out.println("substring(1, 3): " + sb2.substring(1, 3));
    }

    static void practice16() {
        String str = "Hello World";

        // String -> StringBuilder
        StringBuilder sb = new StringBuilder(str);
        sb.append(" - StringBuilder");
        System.out.println("String -> StringBuilder: " + sb);

        // String -> StringBuffer
        StringBuffer sbf = new StringBuffer(str);
        sbf.append(" - StringBuffer");
        System.out.println("String -> StringBuffer: " + sbf);

        // StringBuilder -> String
        String fromSb = sb.toString();
        System.out.println("StringBuilder -> String: " + fromSb);

        // StringBuffer -> String
        String fromSbf = sbf.toString();
        System.out.println("StringBuffer -> String: " + fromSbf);

        // StringBuilder -> StringBuffer через String
        StringBuilder sb2 = new StringBuilder("Convert");
        String temp = sb2.toString();
        StringBuffer sbf2 = new StringBuffer(temp);
        sbf2.append(" successfully");
        System.out.println("StringBuilder -> StringBuffer: " + sbf2);

        // StringBuffer -> StringBuilder через String
        StringBuffer sbf3 = new StringBuffer("Conversion");
        String temp2 = sbf3.toString();
        StringBuilder sb3 = new StringBuilder(temp2);
        sb3.append(" completed");
        System.out.println("StringBuffer -> StringBuilder: " + sb3);

        // Демонстрация производительности
        long startTime, endTime;

        // String concatenation (медленно)
        startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += i;
        }
        endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        // StringBuilder (быстро)
        startTime = System.nanoTime();
        StringBuilder sbFast = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sbFast.append(i);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");

        // StringBuffer (потокобезопасно, но медленнее)
        startTime = System.nanoTime();
        StringBuffer sbfFast = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sbfFast.append(i);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");
    }
}