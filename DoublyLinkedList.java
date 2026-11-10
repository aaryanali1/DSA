public class DoublyLinkedList {
    static class Node {
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

    public void insertEnd(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertStart(int value) {
        Node newNode = new Node(value);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void deleteStart() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(head == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteEnd() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(head == null) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void displayForward() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = tail;
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void deleteValue(int value) {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        if(head.data == value) {
            deleteStart();
            return;
        }
        if(tail.data == value) {
            deleteEnd();
            return;
        }
        Node temp = head;
        while(temp != null) {
            if(temp.data == value) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }
}
