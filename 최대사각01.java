import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대사각01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numColumns = Integer.parseInt(reader.readLine());
        int[] heights = new int[1001];
        int leftMost = 1001;
        int rightMost = 0;

        for (int i = 0; i < numColumns; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int position = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());
            heights[position] = height;
            leftMost = Math.min(position, leftMost);
            rightMost = Math.max(position, rightMost);
        }

        Stack<Integer> stack = new Stack<>();
        int currentHeight = heights[leftMost];

        // Left to right comparison
        for (int i = leftMost + 1; i <= rightMost; i++) {
            System.out.println(heights[i] + " // " + currentHeight);
            if (heights[i] < currentHeight) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int idx = stack.pop();
                    heights[idx] = currentHeight;
                }
                currentHeight = heights[i];
            }
        }
        stack.clear();

        // Right to left comparison
        currentHeight = heights[rightMost];
        for (int i = rightMost - 1; i >= leftMost; i--) {
            if (heights[i] < currentHeight) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int idx = stack.pop();
                    heights[idx] = currentHeight;
                }
                currentHeight = heights[i];
            }
        }

        int totalArea = 0;
        for (int i = leftMost; i <= rightMost; i++) {
            totalArea += heights[i];
        }

        System.out.println(totalArea);
    }
}
