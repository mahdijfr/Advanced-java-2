import java.util.Arrays;

public class QueueImpl <T>{
    public int size;
    public int capacity;
    public T[] queue;

    public QueueImpl() {
        this.size = 0;
        this.capacity = 4;
        this.queue = (T[]) new Object[capacity];
    }

    public boolean add(T element) throws NullElement {
        if (element == null) {
            throw new NullElement();
        }
        if (size == capacity) {
            capacity *= 2;
            queue = Arrays.copyOf(queue, capacity);
        }
        queue[size++] = element;
        return true;
    }

    public boolean offer(T element) {
        if (element == null) {
            return false;
        }
        if (size == capacity) {
            capacity *= 2;
            queue = Arrays.copyOf(queue, capacity);
        }
        queue[size++] = element;
        return true;
    }

    public T element() throws EmptyQueue {
        if (size == 0) {
            throw new EmptyQueue();
        }
        return queue[0];
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return queue[0];
    }

    public T remove() throws EmptyQueue {
        if (size == 0) {
            throw new EmptyQueue();
        }
        T element = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
        return element;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T element = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuilder string = new StringBuilder("");
        string.append("[");
        for (int i = 0; i < size - 1; i++) {
            string.append(this.queue[i]).append(",").append(" ");
        }
        string.append(this.queue[size - 1]).append("]");
        return string.toString();
    }
}
