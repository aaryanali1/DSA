public class StaticQueue {
    int queue[], front, rear, size;

    public StaticQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for(int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " "); 
        }
        System.out.println();
    }

    public void enqueue(int value) {
        if(isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        if(isEmpty()) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % queue.length;
        }
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int value = queue[front];

        if(front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % queue.length;
        }
        size--;
        return value;
    }
}
