public class DynamicQueue {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node front, rear;

    public DynamicQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = front;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        return value;
    }
}
