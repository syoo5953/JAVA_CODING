// 백준 도시 분할 계획
// https://www.acmicpc.net/problem/1647

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 크루스칼01 {
    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int a, int b) {
        int pA = find(parent, parent[a]);
        int pB = find(parent, parent[b]);

        if(pA < pB) {
            parent[pB] = pA;
        } else {
            parent[pA] = pB;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] costs = new int[M][3];
        int[] parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int answer = 0;
        int maxCost = 0;

        for(int i = 0; i < M; i++) {
            if(find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                union(parent, costs[i][0], costs[i][1]);
                answer += costs[i][2];
                maxCost = costs[i][2]; // 가장 최근에 추가된 간선의 비용 (가장 큰 값)
            }
        }
        System.out.println(answer - maxCost);
    }
}
