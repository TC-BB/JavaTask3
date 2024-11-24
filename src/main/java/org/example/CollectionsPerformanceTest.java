package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CollectionsPerformanceTest {

    private static final int ITERATIONS = 2000;
    private static final int LIST_SIZE = 10000; // Размер списка

    public static void main(String[] args) {
        List<Long> arrayListTimes = testCollection(new ArrayList<>());
        List<Long> linkedListTimes = testCollection(new LinkedList<>());

        printResults("ArrayList", arrayListTimes);
        printResults("LinkedList", linkedListTimes);
    }

    private static List<Long> testCollection(List<Integer> list) {
        List<Long> times = new ArrayList<>();
        Random random = new Random();

        // Add
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(random.nextInt(LIST_SIZE));
        }
        long endTime = System.nanoTime();
        times.add(endTime - startTime);

        // Delete (удаляем случайные элементы)
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS / 2; i++) { // Удаляем половину элементов
            list.remove(random.nextInt(list.size()));
        }
        endTime = System.nanoTime();
        times.add(endTime - startTime);

        // Get (получаем случайные элементы)
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.get(random.nextInt(list.size()));
        }
        endTime = System.nanoTime();
        times.add(endTime - startTime);

        return times;
    }


    private static void printResults(String collectionType, List<Long> times) {
        System.out.println("Результаты для " + collectionType + ":");
        System.out.println("| Метод | Выполнений | Время (нс) |");
        System.out.println("|---|---|---|");
        System.out.println("| add | " + ITERATIONS + " | " + times.get(0) + " |");
        System.out.println("| delete | " + ITERATIONS / 2 + " | " + times.get(1) + " |");
        System.out.println("| get | " + ITERATIONS + " | " + times.get(2) + " |");
        System.out.println();
    }
}