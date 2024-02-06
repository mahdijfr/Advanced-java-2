import java.util.LinkedList;

public class Test {
    public static void main(String[] args) throws Exception {
        QueueImpl<Integer> q = new QueueImpl<Integer>();
        System.out.println(q.peek());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.remove();
        q.poll();
        System.out.println(q.peek());
        System.out.println(q.capacity + ", " + q.size);
        q.add(7);
        q.add(8);
        System.out.println(q.size +" "+ q.capacity);
        System.out.println(q.element());
        q.remove();
        q.remove();
        q.offer(19);
        System.out.println(q.toString());
    }
}
