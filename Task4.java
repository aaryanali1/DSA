public class Task4 {
    public static class ArrayStack {
        int array[], top;

        public ArrayStack(int capacity) {
            array = new int[capacity];
            top = -1;
        }

        public void recordAction(int actionID) {
            if(array.length == top + 1) {
                System.out.println("Array stack is full.");
                return;
            }
            array[++top] = actionID;
        }

        public void undoLastAction() {
            if(top == -1) {
                System.out.println("Array stack is empty.");
                return;
            }
            System.out.println("Latest Action: " + array[top]);
            array[top--] = 0;
        }
    }

    public static class LinkedStack {
        public static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                next = null;
            }
        }

        Node top;

        public void recordAction(int actionID) {
            Node newNode = new Node(actionID);
            newNode.next = top;
            top = newNode;
        }

        public void undoLastAction() {
            if(top == null) {
                System.out.println("Linked stack is empty.");
                return;
            }
            System.out.println("Latest Action: " + top.data);
            top = top.next;
        }
    }

    public static class LinearQueue {
        int array[], front, rear;

        public LinearQueue(int capacity) {
            array = new int[capacity];
            front = -1;
            rear = -1;
        }

        public void addJob(int jobID) {
            if(rear + 1 == array.length) {
                System.out.println("Array queue is full.");
                return;
            }
            if(front == -1) {
                front++;
            }
            array[++rear] = jobID;
        }

        public void processJob() {
            if(front == -1) {
                System.out.println("Array queue is empty.");
                return;
            }
            System.out.println("Oldest Job: " + array[front]);
            for(int i = 0; i < rear; i++) {
                array[i] = array[i + 1];
            }
            rear--;
            if(rear < front) {
                front = -1;
                rear = -1;
            }
        }
    }

    public static class LinkedQueue {
        public static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                next = null;
            }
        }

        Node front, rear;

        public void addJob(int jobID) {
            Node newNode = new Node(jobID);
            if(front == null) {
                front = newNode;
                rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public void processJob() {
            if(front == null) {
                System.out.println("Linked queue is empty.");
                return;
            }
            System.out.println("Oldest Job: " + front.data);
            front = front.next;
            if(front == null) {
                rear = null;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----- Array Stack -----");
        ArrayStack as = new ArrayStack(3);
        as.recordAction(1);
        as.recordAction(2);
        as.recordAction(3);
        as.recordAction(4);

        as.undoLastAction();
        as.undoLastAction();
        as.undoLastAction();
        as.undoLastAction();

        System.out.println("----- Linked Stack -----");
        LinkedStack ls = new LinkedStack();
        ls.recordAction(1);
        ls.recordAction(2);
        ls.recordAction(3);

        ls.undoLastAction();
        ls.undoLastAction();
        ls.undoLastAction();
        ls.undoLastAction();

        System.out.println("----- Linear Array Queue -----");
        LinearQueue aq = new LinearQueue(3);
        aq.addJob(1);
        aq.addJob(2);
        aq.addJob(3);

        aq.processJob();
        aq.processJob();
        aq.processJob();
        aq.processJob();

        System.out.println("----- Linked Queue -----");
        LinkedQueue lq = new LinkedQueue();
        lq.addJob(1);
        lq.addJob(2);
        lq.addJob(3);

        lq.processJob();
        lq.processJob();
        lq.processJob();
        lq.processJob();

        lq.addJob(4);
        lq.processJob();
    }
}
