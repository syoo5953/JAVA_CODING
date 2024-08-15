import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Node>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int u = fare[0], v = fare[1], w = fare[2];
            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }

        int[] distFromS = dijkstra(s, adjList, n);
        int[] distFromA = dijkstra(a, adjList, n);
        int[] distFromB = dijkstra(b, adjList, n);

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int cost = distFromS[i] + distFromA[i] + distFromB[i];
            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public int[] dijkstra(int start, List<Node>[] adjList, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.index;
            int d = current.distance;

            if (d > dist[u]) continue;

            for (Node neighbor : adjList[u]) {
                int v = neighbor.index;
                int newDist = dist[u] + neighbor.distance;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Node(v, newDist));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int index, distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {
            {4, 1, 10},
            {3, 5, 24},
            {5, 6, 2},
            {3, 1, 41},
            {5, 1, 24},
            {4, 6, 50},
            {2, 4, 66},
            {2, 3, 22},
            {1, 6, 25}
        };
        
        int result = sol.solution(n, s, a, b, fares);
        System.out.println("최저 예상 택시요금: " + result);
    }
}
