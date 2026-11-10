public class CircularDoublyLinkedList {
    public static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    Node head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void displayForward() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do{
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        while(temp != head);
        System.out.println("(back to head)");
    }

    public void displayBackward() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = tail;
        do{
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        while(temp != tail);
        System.out.println("(back to tail)");
    }

    public void insertStart(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head = newNode;
    }

    public void insertEnd(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        head.prev = newNode;
        tail = newNode;
    }

    public void deleteStart() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    public void deleteEnd() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }
}
