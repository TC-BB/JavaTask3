package org.example;

// Лабораторная работа №3 по языку программирования Java. Выполнил: Фефелов Дмитрий, 3 курс, 3 группа

/**
 * Задача: Работа с коллекциями. Сравнить производительность ArrayList и LinkedList
 *
 * Необходимо написать код, который бы вызывал основные методы коллекций определенное(1000 или 2000, или любое другое) количество раз. При этом должно засекаться время.
 *
 * Минимально необходимо протестировать методы:add, delete, get
 *
 * После этого вывести таблицу с результатами(метод, сколько раз выполнялся, время выполнения)
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CollectionsPerformanceTest {

    private static final int ITERATIONS = 2000; // Количество вызываний методов
    private static final int LIST_SIZE = 10000; // Размер списка

    /**
     * В main создается пустой ArrayList и LinkedList, которые передаются в метод testCollection.
     * Этот метод нужен для измерения времени, за которое выполняется операция.
     * Результаты сохраняются соответственно в arrayListTimes и linkedListTimes.
     */
    public static void main(String[] args) {
        List<Long> arrayListTimes = testCollection(new ArrayList<>());
        List<Long> linkedListTimes = testCollection(new LinkedList<>());

        printResults("ArrayList", arrayListTimes);
        printResults("LinkedList", linkedListTimes);
    }

    /**
     * В методе testCollection будет проводиться измерение времени для операций: add, delete, get.
     * Здесь буду использовать Random для генерации случайных чисел, используемых для индексов при удалении и получении элементов.
     */
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
    /**
     * В методе printResults, форматируются и выводятся результаты измерений.
     */

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