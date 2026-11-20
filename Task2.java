public class Task2 {

    public static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
            next = null;
        }
    }

    public static class RequestList {
        Node head;

        public void insertEnd(int ID) {
            Node newNode = new Node(ID);
            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void insertAfter(int existingID, int newID) {
            if (head == null) {
                System.out.println("Request list is empty.");
                return;
            }

            Node temp = head;
            while (temp != null && temp.id != existingID) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println(existingID + " not found.");
                return;
            }
            Node newNode = new Node(newID);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        public void removeByID(int id) {
            if (head == null) {
                System.out.println("Request list is empty.");
                return;
            }

            if (head.id == id) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.id != id) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println(id + " not found.");
                return;
            }

            temp.next = temp.next.next;
        }

        public void display() {
            if(head == null) {
                System.out.println("Request list is empty.");
                return;
            }

            Node temp = head;
            while(temp != null) {
                System.out.print(temp.id + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static class DNode {
        int id;
        DNode prev, next;

        public DNode(int id) {
            this.id = id;
            prev = null;
            next = null;
        }
    }

    public static class ReturnLog {
        DNode head, tail;

        public void insertEnd(int ID) {
            DNode newNode = new DNode(ID);

            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }

            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        public void insertBefore(int existingID, int newID) {
            if (head == null) {
                System.out.println("Return list is empty.");
                return;
            }

            DNode temp = head;
            while (temp != null && temp.id != existingID) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println(existingID + " not found.");
                return;
            }

            DNode newNode = new DNode(newID);
            newNode.next = temp;
            newNode.prev = temp.prev;

            if (temp.prev == null) {
                head = newNode;
            }
            else {
                temp.prev.next = newNode;
            }
            temp.prev = newNode;
        }

        public void removeReturn(int ID) {
            if (head == null) {
                System.out.println("Return list is empty.");
                return;
            }

            DNode temp = head;

            while (temp != null && temp.id != ID) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println(ID + " not found.");
                return;
            }

            if (temp == head) {
                head = temp.next;
            }

            if (temp == tail) {
                tail = temp.prev;
            }

            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

        public void displayForward() {
            if (head == null) {
                System.out.println("Return list is empty.");
                return;
            }

            DNode temp = head;

            while (temp != null) {
                System.out.print(temp.id + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        System.out.println("----- Singly Linked List -----");
        RequestList requests = new RequestList();
        requests.insertEnd(101);
        requests.insertEnd(205);
        requests.insertEnd(310);
        requests.insertAfter(310, 401);
        requests.removeByID(101);
        requests.display();

        System.out.println("----- Doubly Linked List -----");
        ReturnLog returns = new ReturnLog();
        returns.insertEnd(410);
        returns.insertEnd(520);
        returns.insertEnd(630);
        returns.insertBefore(410, 210);
        returns.removeReturn(520);
        returns.removeReturn(630);
        returns.removeReturn(313);
        returns.displayForward();
    }
}