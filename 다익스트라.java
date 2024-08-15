import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12978

class Solution {
    public List<Node>[] adjList;
    public int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        adjList = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            adjList[r[0]].add(new Node(r[1], r[2]));
            adjList[r[1]].add(new Node(r[0], r[2]));
        }
        
        dijkstra(1);
        
        int answer = 0;
        for (int d : dist) {
            if (d <= K) answer++;
        }
        return answer;
    }
    
    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int idx = current.index;
            int distance = current.distance;
            
            if (distance > dist[idx]) continue;
            
            for (Node next : adjList[idx]) {
                int newDist = distance + next.distance;
                if (newDist < dist[next.index]) {
                    dist[next.index] = newDist;
                    pq.add(new Node(next.index, newDist));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int index;
        int distance;
        
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}


public class 다익스트라 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // 예시 입력 데이터
        int N = 5;
        int[][] road = {
            {1, 2, 1},
            {2, 3, 3},
            {5, 2, 2},
            {1, 4, 2},
            {5, 3, 1},
            {5, 4, 2}
        };
        int K = 3;
        
        // Solution 클래스의 solution 메서드를 호출하고 결과 출력
        int result = sol.solution(N, road, K);
        System.out.println("K 시간 이하로 배달이 가능한 마을 수: " + result);
    }
}
