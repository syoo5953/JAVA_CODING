import java.util.Arrays;

public class 크루스칼 {
    class Solution {
        public static int find(int[] parent, int i) {
            System.out.println("parent[" + i + "] : " + parent[i] + " == " + i);
            if (parent[i] == i)
                return i;
            return find(parent, parent[i]);
        }

        public static void union(int[] parent, int a, int b) {
            int pA = find(parent, parent[a]);
            int pB = find(parent, parent[b]);
            System.out.println("pA = " + pA + " // " + "pB == " + pB);
            if (pA < pB) {
                parent[pB] = pA;
            } else {
                parent[pA] = pB;
            }
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;
            int[] parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
            
            for (int i = 0; i < costs.length; i++) {
                if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                    union(parent, costs[i][0], costs[i][1]);
                    answer += costs[i][2];

                    for (int j = 0; j < parent.length; j++) {
                        System.out.print(parent[j] + ", ");
                    }
                }
                System.out.println();
                System.out.println();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        크루스칼 outerClass = new 크루스칼();
        Solution solution = outerClass.new Solution();
        int[][] maps = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
        int result = solution.solution(4, maps);
        System.out.println(result);
    }
}
