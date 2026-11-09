public class QuestionC1 {
    private int[] data = new int[2];
    private int size = 0;
    public long copies = 0;

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public int get(int index) {
        return data[index];
    }

    public void add(int value) {
        if(size() == capacity()) {
            resize(capacity() * 2);
        }
        data[size()] = value;
        size++;
    }

    private void resize(int newCap) {
        int[] temp = new int[newCap];
        for(int i = 0; i < size(); i++) {
            temp[i] = data[i];
            copies++;
        }
        data = temp;
    }

    public void shrink() {
        if(capacity() > 2 && size() <= capacity() / 4) {
            resize(Math.max(2, capacity() / 2));
        }
    }

    public boolean insertAt(int index, int value) {
        if(index < 0 || index > size()) {
            return false;
        }
        if(size() == capacity()) {
            resize(capacity() * 2);
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    public boolean removeAt(int index) {
        if(index < 0 || index > size() - 1) {
            return false;
        }
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        shrink();
        return true;
    }

    public int removeAll(int value) {
        if(size() == 0) {
            return 0;
        }

        int write = 0, removedCount = 0;
        for(int read = 0; read < size; read++) {
            if(data[read] == value) {
                removedCount++;
            }
            else {
                data[write] = data[read];
                write++;
            }
        }

        size = write;
        if(removedCount > 0) {
            shrink();
        }
        return removedCount;
    }
}