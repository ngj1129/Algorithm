import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = new String(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(str.charAt(j)) - 48;
            }
        }
        System.out.println(bfs(n, m, map));
    }

    public static int bfs(int n, int m, int[][] map) {
        int[][] v = new int[n][m];
        int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1, 0});
        v[0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            int w = cur[3];
            if (x == n - 1 && y == m - 1) {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                if (x + move[i][0] >= 0 && x + move[i][0] < n && y + move[i][1] >= 0 && y + move[i][1] < m) {
                    if (w == 0) {
                        if (map[x + move[i][0]][y + move[i][1]] == 0 && v[x + move[i][0]][y + move[i][1]] <= 0) {
                            q.offer(new int[] { x + move[i][0], y + move[i][1], d + 1, w });
                            v[x + move[i][0]][y + move[i][1]] = 1;
                        }
                        else if (map[x + move[i][0]][y + move[i][1]] == 1 && w == 0 && v[x + move[i][0]][y + move[i][1]] == 0) {
                            q.offer(new int[] { x + move[i][0], y + move[i][1], d + 1, 1 });
                            v[x + move[i][0]][y + move[i][1]] = 1;
                        }
                    }
                    else {
                        if (map[x + move[i][0]][y + move[i][1]] == 0 && v[x + move[i][0]][y + move[i][1]] == 0) {
                            q.offer(new int[] { x + move[i][0], y + move[i][1], d + 1, w });
                            v[x + move[i][0]][y + move[i][1]] = -1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}