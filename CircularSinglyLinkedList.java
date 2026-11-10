public class CircularSinglyLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        while(temp != head);
        System.out.println("(back to head)");
    }

    public void insertEnd(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void insertStart(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        head = newNode;
        temp.next = head;
    }

    public void deleteStart() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
    }

    public void deleteEnd() {
        if(isEmpty()) {
            System.out.println("List is Empty.");
            return;
        }
        if(head.next == head) {
            deleteStart();
            return;
        }
        Node temp = head;
        while(temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public void deleteValue(int value) {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(head.data == value) {
            deleteStart();
            return;
        }
        Node temp = head;
        while(temp.next != head && temp.next.data != value) {
            temp = temp.next;
        }

        if(temp.next == head) {
            System.out.println("Value not found.");
            return;
        }
        if(temp.next.next == head) {
            deleteEnd();
            return;
        }
        temp.next = temp.next.next;
    }
}
