// Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

package Homework.Sem_3_1;

public class LinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size = 1;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    public void reverse() {
        if (head == null)
            System.out.println("List is empty");
        else {
            Node currentNode = head;
            Node temp = null;
            Node previously = null;
            while (currentNode != null) {
                temp = currentNode.next;
                currentNode.next = previously;
                previously = currentNode;
                currentNode = temp;
            }
            head = previously;
        }
    }

    public void print() {
        Node currentNode = head;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    private class Node {
        int value;
        Node next;

        Node() {
            next = null;
        }

        Node(int _value) {
            this.value = _value;
        }

        Node(int _value, Node _next) {
            this.value = _value;
            this.next = _next;
        }
    }
}
