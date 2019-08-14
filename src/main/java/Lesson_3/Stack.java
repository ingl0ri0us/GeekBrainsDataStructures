package Lesson_3;

public class Stack {
    private int maxSize;
    private char[] stackArr;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize);
    }

    public void push(char i) {
        stackArr[++top] = i;
    }

    public char pop() {
        return stackArr[top--];
    }

    public char peek() {
        return stackArr[top];
    }
}
