public class QuestionC2 {
    private static class Node {
        String action; 
        Node next;
        
        Node(String a, Node n) {
            action = a; next = n;
        }
    }
    private String[] buf;
    private int front, size;
    private Node redoTop;
    private int redoSize;

    public QuestionC2(int cap) {
        buf = new String[cap]; 
        front = 0; 
        size = 0;
        redoTop = null; 
        redoSize = 0;
    }

    public boolean perform(String action) {
        if(action == null) {
            return false;
        }

        redoTop = null;
        redoSize = 0;

        if(size < buf.length) {
            int index = (front + size) % buf.length;
            buf[index] = action;
            size++;
        }
        else {
            buf[front] = action;
            front = (front + 1) % buf.length;
        }

        return true;
    }

    public String undo() {
        if(size == 0) {
            return null;
        }

        int index = (front + size - 1) % buf.length;
        String action = buf[index];
        buf[index] = null;
        size--;

        redoTop = new Node(action, redoTop);
        redoSize++;
    
        return action;
    }

    public String redo() {
        if(redoTop == null) {
            return null;
        }
        
        String action = redoTop.action;
        redoTop = redoTop.next;
        redoSize--;

        int index = (front + size) % buf.length;
        buf[index] = action;
        size++;

        return action;
    }

    public String[] historySnapshot() {
        String[] history = new String[size];

        for(int i = 0; i < size; i++) {
            int index = (front + i) % buf.length;
            history[i] = buf[index];
        }
        return history;
    }
}