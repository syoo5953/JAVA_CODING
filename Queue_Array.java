public class Queue_Array {
    private int[] queue;
    private int maxSize;
    private int front;
    private int rear;
    private int currSize;
    
    public void push(int item) {
        queue = new int[item];
        maxSize = item;
        front = 0;
        rear = -1;
        currSize = 0;
    }

    public void enqueue(int item) {
        if(currSize < maxSize) {
            if(rear == maxSize - 1) {
                rear = - 1;
            }
            queue[++rear] = item;
            currSize++;
        }
    }

    public int dequeue() {
        if(currSize > 0) {
            int temp = queue[front++];
            if(front == maxSize) front = 0;
            currSize--;
            return temp;
        }
        return - 1;
    }

    public int peekFront() {
        if(currSize > 0) {
            return queue[front];
        }
        return -1;
    }
}
