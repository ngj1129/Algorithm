import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] rec = new boolean[m][n];
        boolean[][] v = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = m - Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = m - Integer.parseInt(st.nextToken());

            for (int x = x1-1; x >= x2; x--) {
                for (int y = y1; y < y2; y++) {
                    rec[x][y] = true;
                }
            }
        }

        for (int i = 0; i < rec.length; i++) {
            for (int j = 0; j < rec[0].length; j++) {
                if (!rec[i][j] && !v[i][j]) {
                    v[i][j] = true;
                    q.offer(new int[] { i, j });
                    list.add(bfs(rec, q, v));
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        System.out.println(answer.length);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
    }

    public static int bfs(boolean[][] rec, Queue<int[]> q, boolean[][] v) {
        int r = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            if (x < rec.length - 1) {
                if (!rec[x + 1][y] && !v[x + 1][y]) {
                    v[x + 1][y] = true;
                    q.offer(new int[] { x + 1, y });
                    r++;
                }
            }
            if (y < rec[0].length - 1) {
                if (!rec[x][y + 1] && !v[x][y + 1]) {
                    v[x][y + 1] = true;
                    q.offer(new int[] { x, y + 1 });
                    r++;
                }
            }
            if (x > 0) {
                if (!rec[x - 1][y] && !v[x - 1][y]) {
                    v[x - 1][y] = true;
                    q.offer(new int[] { x - 1, y });
                    r++;
                }
            }
            if (y > 0) {
                if (!rec[x][y - 1] && !v[x][y - 1]) {
                    v[x][y - 1] = true;
                    q.offer(new int[] { x, y - 1 });
                    r++;
                }
            }
        }
        return r + 1;
    }
}