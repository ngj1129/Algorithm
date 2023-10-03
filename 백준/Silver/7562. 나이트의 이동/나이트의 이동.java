import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int l;
        int[] start = new int[2];
        int[] goal = new int[2];
        int[][] move = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        boolean[][] v;
        Queue<int[]> q;
        for (int t=0; t<T; t++) {
            l = Integer.parseInt(br.readLine());
            v = new boolean[l][l];
            q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());
            q.offer(new int[]{start[0], start[1], 0});
            v[start[0]][start[1]] = true;
            System.out.println(bfs(l, goal, v, q, move));
        }
    }  
    public static int bfs(int l, int[] goal, boolean[][] v, Queue<int[]> q, int[][] move) {
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int d = tmp[2];
            if (x == goal[0] && y == goal[1]) {
                return d;
            }
            for (int[] m: move) {
                if (x+m[0]>=0 && x+m[0]<l && y+m[1]>=0 && y+m[1]<l) {
                    if (!v[x+m[0]][y+m[1]]) {
                        q.offer(new int[]{x+m[0], y+m[1], d+1});
                        v[x+m[0]][y+m[1]] = true;
                    }
                }
            }
        }
        return 0;
    }
}