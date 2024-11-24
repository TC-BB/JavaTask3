package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionsPerformanceTestTest {

    @Test
    void testArrayListCreation() {
        List<Integer> list = new ArrayList<>();
        assertNotNull(list);
    }

    @Test
    void testLinkedListCreation() {
        List<Integer> list = new LinkedList<>();
        assertNotNull(list);
    }

    @Test
    void testAddArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }
    @Test
    void testAddLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(5, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertTrue(list.contains(5));
    }

    @Test
    void testDeleteLinkedList() {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        list.remove(Integer.valueOf(3)); // Удалим элемент со значением 3
        assertEquals(4, list.size());
        assertFalse(list.contains(3));
    }

    @Test
    void testGetArrayList() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
        assertEquals(20, list.get(1));
    }
    @Test
    void testDeleteRandomLinkedList(){
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            list.add(random.nextInt(100));
        }
        int size = list.size();
        int indexToDelete = random.nextInt(size);
        int elementToDelete = list.get(indexToDelete);
        list.remove(indexToDelete);
        assertEquals(size -1, list.size());
        assertFalse(list.contains(elementToDelete));
    }

    @Test
    void testGetRandomArrayList(){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            list.add(random.nextInt(100));
        }
        int indexToGet = random.nextInt(list.size());
        assertEquals(list.get(indexToGet), list.get(indexToGet));
    }
}