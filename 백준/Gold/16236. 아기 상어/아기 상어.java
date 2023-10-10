import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] place = new int[N][N];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                if (place[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;
                    place[i][j] = 0;
                }
            }
        }
        System.out.println(bfs(N, place, start));
    }

    public static int bfs(int N, int[][] place, int[] start) {
        int lv = 2;
        int ct = 0;
        int time = 0;
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        ArrayList<int[]> list = new ArrayList<>();
        q.offer(new int[] { start[0], start[1], 0});
        v[start[0]][start[1]] = true;
        while (true) {
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                time = tmp[2];
    
                for (int[] m: move) {
                    if (x+m[0]>=0 && x+m[0]<N && y+m[1]>=0 && y+m[1]<N) {
                        if (!v[x+m[0]][y+m[1]] && lv >= place[x+m[0]][y+m[1]]) { //들어가거나 먹을수있으면
                            q.offer(new int[]{x+m[0], y+m[1], time+1});
                            v[x+m[0]][y+m[1]] = true;
                            if (place[x+m[0]][y+m[1]] > 0 && lv > place[x+m[0]][y+m[1]]) {//들어갈수있으면
                                list.add(new int[]{x+m[0], y+m[1], time+1});
                            }
                        }
                    }
                }
            }
            if (list.size() == 0) {
                return answer;
            }
                
            int mx = list.get(0)[0];
            int my = list.get(0)[1];
            int d = list.get(0)[2];
            for (int i=1; i<list.size(); i++) {
                if (list.get(i)[2] < d) {
                    mx = list.get(i)[0];
                    my = list.get(i)[1];
                    d = list.get(i)[2];
                }
                else if (list.get(i)[2] == d) {
                    if (list.get(i)[0] < mx) {
                        mx = list.get(i)[0];
                        my = list.get(i)[1];
                        d = list.get(i)[2];
                    }
                    else if (list.get(i)[0] == mx) {
                        if (list.get(i)[1] < my) {
                            mx = list.get(i)[0];
                            my = list.get(i)[1];
                            d = list.get(i)[2];
                        }
                    }
                }
            }
            answer = d;
            ct++;
            if (ct == lv) {
                lv++;
                ct = 0;
            }
            //q.clear();
            list = new ArrayList<int[]>();
            v = new boolean[N][N];
            place[mx][my] = 0;
            q.offer(new int[]{mx, my, d});
            v[mx][my] = true;
        }
    }
}