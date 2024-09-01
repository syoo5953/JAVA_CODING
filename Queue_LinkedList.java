import java.util.*;

public class Queue_LinkedList {
    private LinkedList<Integer> list;
    
    public Queue_LinkedList() {
        list = new LinkedList<>();
    }
    public void enqueue(int item) {
        list.add(item);
    }

    public int dequeue() {
        return list.removeFirst();
    }

    public int peekFront() {
        return list.getFirst();
    }
}
