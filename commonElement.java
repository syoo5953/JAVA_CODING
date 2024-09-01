import java.util.*;

public class commonElement {
    public static void main(String[] args) {
        int[] first = {1, 3, 9, 5, 2};
        int[] second = {3, 2, 5, 7, 8};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int f : first) {
            hm.put(f, hm.getOrDefault(f, 0) + 1);
        }

        for(int s : second) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        for(int answer : hm.keySet()) {
            if(hm.get(answer) == 2) {
                System.out.println(answer);
            }
        }
    }
}
