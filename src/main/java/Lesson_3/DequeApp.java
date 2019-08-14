package Lesson_3;

public class DequeApp {
    public static void main(String[] args) {
        Deque deque = new Deque(10);

        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertLeft(5);
        deque.insertRight(10);
        deque.insertRight(9);
        deque.insertRight(8);
        deque.insertRight(7);
        deque.insertRight(6);

        for (int i = 0; i < 10 ; i++) {
            System.out.println(deque.getLeft());
            deque.removeLeft();
        }
    }
}
