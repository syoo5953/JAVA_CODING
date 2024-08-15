import java.util.*;

public class BFS_게임맵 {
    class Point {
        int r, c, dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    class Solution {
        public int solution(int[][] maps) {
            int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            int endR = maps.length;
            int endC = maps[0].length;
            boolean[][] visited = new boolean[endR][endC];
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0, 0, 0));
            visited[0][0] = true;

            while(!q.isEmpty()) {
                System.out.println("위치 : {" + q.peek().r + ", " + q.peek().c + "}");
                Point p = q.poll();
                if(p.r == endR - 1 && p.c == endC - 1) return p.dist + 1;

                for(int i = 0; i < 4; i++) {
                    int nr = p.r + dir[i][0];
                    int nc = p.c + dir[i][1];

                    if(nr < 0 || nr >= endR || nc < 0 || nc >= endC) continue;
                    if(visited[nr][nc]) continue;
                    if(maps[nr][nc] == 0) continue;
                    
                    System.out.println("추가! : {" + nr + ", " + nc + "}");
                    q.add(new Point(nr, nc, p.dist + 1));
                    visited[nr][nc] = true;
                }
                System.out.println();
            }

            return -1;
        }
    }
    public static void main(String[] args) {
        BFS_게임맵 outerClass = new BFS_게임맵();
        Solution solution = outerClass.new Solution();
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        int result = solution.solution(maps);
        System.out.println(result);
    }
}