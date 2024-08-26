import java.io.*;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 1, 3};

        int uniqueElement = findUniqueElement(array);

        System.out.println("단 한 번 등장한 원소: " + uniqueElement);
    }

    public static int findUniqueElement(int[] array) {
        int result = 0;
        for (int num : array) {
            result ^= num;  // XOR 연산
            System.out.println(result);
        }
        return result;
    }
}
