import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 최대사각 {
    public static void main(String[] args) throws IOException {
        int[] height = new int[501];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int[] originalHeight = height.clone();
        Stack<Integer> stack = new Stack<>();
        int currentHeight = height[0];

        for (int i = 1; i <= w; i++) {
            if (height[i] < currentHeight) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    height[index] = currentHeight;
                }
                currentHeight = height[i];
            }
        }

        stack.clear();
        currentHeight = height[w - 1];
        for (int i = w - 1; i >= 0; i--) {
            if (height[i] < currentHeight) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    height[index] = currentHeight;
                }
                currentHeight = height[i];
            }
        }

        int addedArea = 0;
        for (int i = 0; i < w; i++) {
            if (height[i] > originalHeight[i]) {
                addedArea += (height[i] - originalHeight[i]);
            }
        }

        System.out.println(addedArea);
    }
}
