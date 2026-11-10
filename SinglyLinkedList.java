public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertEnd(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertStart(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void deleteEnd() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        if(head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteStart() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }
}