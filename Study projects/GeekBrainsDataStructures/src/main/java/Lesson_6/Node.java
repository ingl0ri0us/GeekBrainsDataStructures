package Lesson_6;

public class Node {
    public int id;
    public int number;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print("[id: " + id + ", data: " + number + "]");
    }
}
