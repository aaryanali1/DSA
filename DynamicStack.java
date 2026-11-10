public class DynamicStack {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack Underflow.");
            return;
        }
        Node temp = top;
        while(temp != null) {
            System.out.printf("| %3d |\n", temp.data);
            System.out.println("-".repeat(7));
            temp = temp.next;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow.");
            return -1;
        }

        int temp = top.data;
        top = top.next;
        return temp;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack Underflow.");
            return -1;
        }

        return top.data;
    }
}
