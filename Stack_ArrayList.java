import java.util.*;

public class Stack_ArrayList {
    private ArrayList<Integer> stack;
    
    public Stack_ArrayList() {
        stack = new ArrayList<>();
    }
    public void push(int item) {
        stack.add(item);
    }  

    public int pop() {
        if(!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return -1;
    }

    public int peek() {
        if(!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return -1;
    }
}
