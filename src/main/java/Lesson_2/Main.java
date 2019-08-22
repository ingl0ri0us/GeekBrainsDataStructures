package Lesson_2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyArr randomArray1 = new MyArr(1_000_000);
        MyArr randomArray2 = new MyArr(1_000_000);
        MyArr randomArray3 = new MyArr(1_000_000);
        MyArr sortedArray = new MyArr(1_000_000);
        Random random = new Random();

        for (int i = 0; i < sortedArray.getSize(); i++) {
            sortedArray.setElement(i,i);
        }

        long startOfSimpleSearch = System.currentTimeMillis();
        int findIndex = sortedArray.findIndex(sortedArray.getSize() - 3000);
        long endOfSimpleSearch = System.currentTimeMillis();
        System.out.println("Index of searched = " + findIndex);
        System.out.println("Simple search time = "+ (endOfSimpleSearch - startOfSimpleSearch));

        long startOfBinarySearch = System.currentTimeMillis();
        int binaryFindIndex = sortedArray.binaryFindIndex(sortedArray.getSize() - 3000);
        long endOfBinarySearch = System.currentTimeMillis();
        System.out.println("Index of searched element = " + binaryFindIndex);
        System.out.println("Binary search time = " + (endOfBinarySearch - startOfBinarySearch));


        long startOfRandomInsert = System.currentTimeMillis();
        for (int i = 0; i < randomArray1.getSize(); i++) {
            randomArray1.setElement(i, random.nextInt(100000));
        }
        long endOfRandomInsert = System.currentTimeMillis();

        System.out.println("Random insertion time = " + (endOfRandomInsert - startOfRandomInsert));

        for (int i = 0; i < randomArray2.getSize(); i++) {
            randomArray2.setElement(i, random.nextInt(100000));
        }
        for (int i = 0; i < randomArray3.getSize(); i++) {
            randomArray3.setElement(i, random.nextInt(100000));
        }
        long startOfBubbleSort = System.currentTimeMillis();
        randomArray1.sortBubble();
        long endOfBubbleSort = System.currentTimeMillis();

        System.out.println("BubbleSort time = " + (endOfBubbleSort - startOfBubbleSort));

        long startOfSelectSort = System.currentTimeMillis();
        randomArray2.sortSelect();
        long endOfSelectSort = System.currentTimeMillis();

        System.out.println("SelectionSort time = " + (endOfSelectSort - startOfSelectSort));

        long startOfInsertSort = System.currentTimeMillis();
        randomArray3.sortInsert();
        long endOfInsertSort = System.currentTimeMillis();

        System.out.println("InsertionSort time = " + (endOfInsertSort - startOfInsertSort));

//        results:
//        Index of searched = 997000
//        Simple search time = 9
//        Index of searched element = 997000
//        Binary search time = 0
//        Random insertion time = 31
//        BubbleSort time = 1878097
//        SelectionSort time = 416475
//        InsertionSort time = 104372

    }
}
