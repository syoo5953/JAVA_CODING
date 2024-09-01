public class Stack_Array {
    int[] stack;
    int top;
    int maxSize;

    public Stack_Array(int size) {
        maxSize = size;
        stack = new int[size];
        top = -1;
    }
    
    public void push(int item) {
        if(top < maxSize - 1) {
            stack[++top] = item;;
        }
    }

    public int pop() {
        if(top >= maxSize) {
            return stack[top--];
        }
        return -1;
    }

    public int peek() {
        if(top >= maxSize) {
            return stack[top];
        }
        return -1;
    }
}
