public class Task3 {
    public static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
            next = null;
        }
    }
    
    Node current;

    public void insertEnd(int ID) {
        Node newNode = new Node(ID);
        if(current == null) {
            current = newNode;
            current.next = newNode;
            return;
        }
        Node temp = current;
        while(temp.next != current) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = current;
    }

    public void joinAfterCurrent(int newID) {
        Node newNode = new Node(newID);
        if(current == null) {
            current = newNode;
            current.next = newNode;
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void advanceTurn() {
        if(current == null) {
            System.out.println("Player list is empty.");
            return;
        }
        if(current.next == current) {
            System.out.println("List only has one player.");
            return;
        }
        current = current.next;
        System.out.println("ID: " + current.id);
    }

    public int turnsUntil(int id) {
        if(current == null) {
            return -1;
        }
        Node temp = current;
        int count = 0;
        do{
            if(temp.id == id) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        while(temp != current);
        return -1;
    }

    public static void main(String[] args) {
        Task3 players = new Task3();
        players.insertEnd(11);
        players.insertEnd(22);
        players.insertEnd(33);
        players.insertEnd(44);
        players.joinAfterCurrent(55);

        players.advanceTurn();
        players.advanceTurn();
        players.advanceTurn();
        players.advanceTurn();
        players.advanceTurn();
        players.advanceTurn();

        System.out.println("Turns Until Current player: " + players.turnsUntil(players.current.id));
        System.out.println("Turns Until Another player: " + players.turnsUntil(33));
        System.out.println("Turns Until Absent player: " + players.turnsUntil(66));
    }
}