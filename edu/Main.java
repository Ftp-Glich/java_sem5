public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
    }

    static void practice1() {
        // try без catch и finally - недопустимо
        // Следующий код не скомпилируется:
        /*
        try {
            System.out.println("Попытка выполнить код");
        }
        */

        System.out.println("Конструкция try без catch и finally недопустима в Java");
        System.out.println("Компилятор выдаст ошибку: 'try' without 'catch', 'finally' or resource declarations");
    }

    static void practice2() {
        // try только с finally - допустимо
        try {
            System.out.println("Выполняем код в try блоке");
            int result = 10 / 2; // Успешная операция
            System.out.println("Результат: " + result);
        } finally {
            System.out.println("Блок finally выполняется всегда, даже если исключения не было");
        }

        System.out.println("Программа продолжает работу");

        // Пример с исключением в try с finally
        try {
            System.out.println("Попытка деления на ноль");
            int result = 10 / 0; // ArithmeticException
        } finally {
            System.out.println("Блок finally выполняется даже при исключении");
        }
        // Исключение не перехвачено, поэтому программа аварийно завершится после finally
    }

    static void practice3() {
        // try с двумя finally - недопустимо
        // Следующий код не скомпилируется:
        /*
        try {
            System.out.println("Код в try");
        } finally {
            System.out.println("Первый finally");
        } finally {
            System.out.println("Второй finally");
        }
        */

        System.out.println("Нельзя использовать несколько блоков finally для одного try");
        System.out.println("Компилятор выдаст ошибку");

        // Но можно использовать вложенные try с finally
        try {
            System.out.println("Внешний try");
            try {
                System.out.println("Внутренний try");
                int[] arr = new int[1];
                arr[5] = 10; // ArrayIndexOutOfBoundsException
            } finally {
                System.out.println("Finally внутреннего try");
            }
        } catch (Exception e) {
            System.out.println("Перехвачено во внешнем catch: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Finally внешнего try");
        }
    }

    // Дополнительный пример с return в try и finally
    static int testReturnInTryFinally() {
        try {
            System.out.println("В try блоке перед return");
            return 1;
        } finally {
            System.out.println("В finally блоке, выполняется ДО возврата значения");
            // return 2; // Если раскомментировать, вернется 2, а не 1
        }
    }

    // Пример с исключением в finally
    static void testExceptionInFinally() {
        try {
            System.out.println("В try блоке");
            // Какая-то логика
        } finally {
            System.out.println("В finally блоке");
            throw new RuntimeException("Исключение из finally");
        }
    }
}