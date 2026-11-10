public class StaticStack {
    int stack[], top;

    public StaticStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack Underflow.");
            return;
        }
        for(int i = top; i >= 0; i--) {
            System.out.printf("| %3d |\n", stack[i]);
            System.out.println("-".repeat(7));
        }
    }

    public void push(int value) {
        if(isFull()) {
            System.out.println("Stack Overflow.");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow.");
            return -1;
        }
        int temp = stack[top];
        stack[top--] = 0;
        return temp;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack Underflow.");
            return -1;
        }
        return stack[top];
    }
}
