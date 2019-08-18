package Lesson_3;

public class Deque {
    private int maxSize;
    private int[] dequeArr;
    private int leftElement;
    private int rightElement;

    public Deque (int size) {
        maxSize = size;
        dequeArr = new int[maxSize];
        leftElement = -1;
        rightElement = 0;
    }

    public boolean isFull() {
        return ((leftElement==0 && rightElement == maxSize - 1) ||
                leftElement == rightElement + 1);
    }

    public boolean isEmpty() {
        return (leftElement == -1);
    }

    public void insertLeft(int item) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if(leftElement == -1) {
            leftElement = 0;
            rightElement = 0;
        } else if (leftElement == 0) {
            leftElement = maxSize - 1;
        } else {
            leftElement = leftElement - 1;
        }
        dequeArr[leftElement] = item;
    }

    public void insertRight(int item) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (rightElement == -1) {
            rightElement = 0;
            leftElement = 0;
        } else if (rightElement == maxSize - 1) {
            rightElement = 0;
        } else {
            rightElement = rightElement + 1;
        }
        dequeArr[rightElement] = item;
    }

    public void removeLeft() {
        if(isEmpty()) {
            System.out.println("Deque id empty");
            return;
        }
        if (leftElement == rightElement) {
            leftElement = -1;
            rightElement = -1;
        } else {
            if (leftElement == maxSize - 1) {
                leftElement = 0;
            } else {
                leftElement = leftElement + 1;
            }
        }
    }

    public void removeRight() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        if (leftElement == rightElement) {
            leftElement = -1;
            rightElement = -1;
        } else if (rightElement == 0) {
            rightElement = maxSize - 1;
        } else {
            rightElement = rightElement - 1;
        }
    }

    public int getLeft() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return dequeArr[leftElement];
    }

    public int getRight() {
        if(isEmpty() || rightElement < 0) {
            System.out.println("Deque is empty");
            return -1;
        }
        return dequeArr[rightElement];


    }




}
