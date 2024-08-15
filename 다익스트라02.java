import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다익스트라02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken()); // 헛간의 개수
        int M = Integer.parseInt(st.nextToken()); // 길의 개수

        // 인접 리스트 초기화
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 길 정보 입력 받아 인접 리스트에 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }

        // 다익스트라 알고리즘 실행
        int[] dist = dijkstra(1, adjList, N);

        // 헛간 1에서 헛간 N까지의 최소 여물 비용을 출력
        System.out.println(dist[N]);
    }

    // 다익스트라 알고리즘 구현
    public static int[] dijkstra(int start, List<Node>[] adjList, int n) {
        int[] dist = new int[n + 1]; // 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 무한대로 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 시작 노드 추가
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll(); // 현재 노드 꺼내기
            int u = curr.idx;
            int d = curr.dist;

            if (d > dist[u]) continue; // 이미 최적화된 경로가 있으면 건너뜀

            for (Node next : adjList[u]) { // 인접 노드들에 대해
                int v = next.idx;
                int newDist = next.dist + dist[u];

                if (newDist < dist[v]) { // 더 짧은 경로를 발견하면
                    dist[v] = newDist; // 갱신
                    pq.add(new Node(v, newDist)); // 우선순위 큐에 추가
                }
            }
        }
        return dist; // 최종 거리 반환
    }

    // 우선순위 큐에서 사용할 Node 클래스
    static class Node implements Comparable<Node> {
        int idx, dist;

        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist - other.dist; // 거리 기준으로 정렬
        }
    }
}
