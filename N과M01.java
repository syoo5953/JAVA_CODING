import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M01 {
    static int N, M;
    static int[] selected;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        used = new boolean[N + 1];

        backtrack(0);
    }

    public static void backtrack(int depth) {
        if (depth == M) {
            // for (int i = 0; i < M; i++) {
            //     System.out.print(selected[i] + " ");
            // }
            // System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                selected[depth] = i;
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
}
