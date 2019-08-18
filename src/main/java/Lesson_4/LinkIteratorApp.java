package Lesson_4;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.getCurrent().display();
        itr.insertAfter("Sergey", 10);
        itr.insertBefore("Vovka", 33);
        itr.deleteCurrent();

        list.display();

    }
}
