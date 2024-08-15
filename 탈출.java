import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 탈출 {
    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];
        int startR = -1, startC = -1;
        int endR = -1, endC = -1;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[r][c];
        Queue<Point> q = new LinkedList<>();
        Queue<Point> waterQueue = new LinkedList<>();

        for(int i = 0; i < r; i++) {
            char[] charArray = reader.readLine().toCharArray();
            board[i] = charArray;
            for(int j = 0; j < c; j++) {
                if(charArray[j] == 'S') {
                    startR = i;
                    startC = j;
                } else if(charArray[j] == 'D') {
                    endR = i;
                    endC = j;
                } else if(charArray[j] == '*') {
                    waterQueue.add(new Point(i, j, 0));
                }
            }
        }

        // 고슴도치의 시작점 추가
        q.add(new Point(startR, startC, 0));
        visited[startR][startC] = true;

        while(!q.isEmpty()) {
            // 먼저 물을 확장
            int waterQueueSize = waterQueue.size();
            for(int i = 0; i < waterQueueSize; i++) {
                Point water = waterQueue.poll();
                for(int j = 0; j < 4; j++) {
                    int nr = water.r + dir[j][0];
                    int nc = water.c + dir[j][1];

                    if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    if(board[nr][nc] == '.' || board[nr][nc] == 'S') {
                        board[nr][nc] = '*';
                        waterQueue.add(new Point(nr, nc, water.time + 1));
                    }
                }
            }

            // 고슴도치의 이동 처리
            int queueSize = q.size();
            for(int i = 0; i < queueSize; i++) {
                Point p = q.poll();
                for(int j = 0; j < 4; j++) {
                    int nr = p.r + dir[j][0];
                    int nc = p.c + dir[j][1];

                    if(nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc]) continue;
                    if(board[nr][nc] == 'D') {
                        System.out.println(p.time + 1);
                        return;
                    }

                    if(board[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc, p.time + 1));
                    }
                }
            }

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    System.out.print(board[i][j] + "");

                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("KAKTUS");
    }
}
