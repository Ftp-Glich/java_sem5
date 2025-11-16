import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        practice1();
        practice2();
    }

    // Практика #1 — что произойдёт при a1 = a2
    public static void practice1() {
        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};

        a1 = a2;
        // Теперь обе переменные указывают на ОДИН И ТОТ ЖЕ массив {6,7,8,9,10}

        System.out.println(Arrays.toString(a1)); // [6, 7, 8, 9, 10]
    }

    // Практика #2 — примеры использования методов класса java.util.Arrays
    public static void practice2() {

        int[] arr = {5, 2, 9, 1, 7};
        int[] arr2 = {5, 2, 9, 1, 7};

        // toString — возвращает строковое представление массива
        System.out.println(Arrays.toString(arr));

        // sort — сортировка массива
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // binarySearch — поиск элемента в отсортированном массиве
        int index = Arrays.binarySearch(arr, 7);
        System.out.println("index of 7 = " + index);

        // equals — сравнение двух массивов поэлементно
        System.out.println("equals: " + Arrays.equals(arr, arr2));

        // compare — лексикографическое сравнение массивов
        // возвращает <0, если arr < arr2; 0 — равны; >0 — arr > arr2
        System.out.println("compare: " + Arrays.compare(arr, arr2));
    }
}
