public class ArrayList {
    int array[], size;

    public ArrayList() {
        array = new int[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void increaseCapacity() {
        int temp[] = new int[array.length + 2];
        for(int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void insert(int value) {
        if(isFull()) {
            increaseCapacity();
        }
        array[size] = value;
        size++;
    }

    public void insertAt(int index, int value) {
        if(index < 0) {
            System.out.println("Index cannot be negative.");
            return;
        }
        if(index > size) {
            System.out.println("Index out of bounds.");
            return;
        }
        if(isFull()) {
            increaseCapacity();
        }
        for(int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public void deleteAt(int index) {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        if(index < 0) {
            System.out.println("Index cannot be negative.");
            return;
        }
        if(index > size - 1) {
            System.out.println("Index out of bounds.");
            return;
        }
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
        
    public void deleteValue(int value) {
        if(isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        int index = -1;
        for(int i = 0; i < size; i++) {
            if(array[i] == value) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            System.out.println("Value not found");
            return;
        }

        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
}