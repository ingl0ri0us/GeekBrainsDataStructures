package Lesson_4;

public class LinkedList <T> {
    public Link first;
    public Link last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public LinkIterator getIterator() {
        return new LinkIterator(this);
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(String name, int age) {
        Link newLink = new Link(name, age);
        if (this.isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertQueue(String name, int age) {
        Link newLink = new Link(name, age);
        if (this.isEmpty()) {
            first = newLink;
        }else {
            last.next = newLink;
        }
        last = newLink;
    }

    public void insertLast(String name, int age) {
        Link newLink = new Link(name,age);
        if(this.isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public Link delete() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public String deleteString() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp.name;

    }

    public void display() {
        Link current = first;
        while(current != null) {
            current.display();
            current = current.next;
        }
    }

    public Link find(String name) {
        Link current = first;
        while(current.name != name) {
            if(current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(String name) {
        Link current = first;
        Link previous = first;
        while(current.name != name) {
            if(current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if(current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}
