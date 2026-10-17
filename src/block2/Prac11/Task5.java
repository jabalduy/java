package block2.Prac11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task5 {

    public static void testList(List<Integer> list, String name) {

        long start;
        long end;

        // Добавление в конец
        start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        end = System.currentTimeMillis();

        System.out.println(name + " add: " + (end - start) + " ms");


        // Вставка в начало
        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            list.add(0, i);
        }

        end = System.currentTimeMillis();

        System.out.println(name + " insert: " + (end - start) + " ms");


        // Поиск
        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            list.contains(50000);
        }

        end = System.currentTimeMillis();

        System.out.println(name + " search: " + (end - start) + " ms");


        // Удаление из начала
        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            list.remove(0);
        }

        end = System.currentTimeMillis();

        System.out.println(name + " remove: " + (end - start) + " ms");

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        testList(arrayList, "ArrayList");
        testList(linkedList, "LinkedList");
    }
}
