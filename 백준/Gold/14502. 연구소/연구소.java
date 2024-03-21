import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[][] virus;
    public static int[][] safe;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int n;
    public static int m;
    public static int s; // 0 개수
    public static int v; // 2 개수
    public static Queue<int[]> q = new LinkedList<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = 0;
        s = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    v++;
                }
                if (map[i][j] == 0) {
                    s++;
                }
            }
        }
        virus = new int[v][2]; // 2의 위치정보
        safe = new int[s][2]; // 0의 위치정보
        int iv = 0;
        int is = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 2) {
                    virus[iv] = new int[]{i, j};
                    q.offer(new int[]{i, j});
                    iv++;
                }
                if (map[i][j] == 0) {
                    safe[is] = new int[]{i, j};
                    is++;
                }
            }
        }
        dfs(3, new int[3], 0, 0);// 벽 세울 위치 3개 뽑기
        System.out.println(answer);
        // map[0][0] = 1;
        // map[0][1] = 1;
        // map[0][2] = 1;
        // q.offer(new int[]{1, 5});
        // q.offer(new int[]{2, 5});
        // q.offer(new int[]{3, 5});
        //bfs(map, q, new boolean[n][m], s);

    }

    public static void dfs(int r, int[] out, int start, int depth) {
        if (depth == 3) {
            for (int i=0; i<3; i++) { //뽑은 세개의 0 위치에 벽 세우기
                int ix = out[i];
                map[safe[ix][0]][safe[ix][1]] = 1;
            }
            Queue<int[]> newq = new LinkedList<>(q);
            // System.out.print(Arrays.toString(safe[out[0]]) + " ");
            // System.out.print(Arrays.toString(safe[out[1]]) + " ");
            // System.out.println(Arrays.toString(safe[out[2]]));
            // System.out.println("==============================");
            bfs(map, newq, new boolean[n][m], s-3);
            for (int i=0; i<3; i++) { //뽑은 세개의 0 위치에 벽 세우기
                int ix = out[i];
                map[safe[ix][0]][safe[ix][1]] = 0;
            }
            return;
        }
        for (int i=start; i<s; i++) {
            out[depth] = i;
            dfs(r, out, i+1, depth+1);
        }
    }

    public static void bfs(int[][] map, Queue<int[]> newq, boolean[][] visited, int num) {
        while (!newq.isEmpty()) {
            int[] cur = newq.poll();
            for (int[] mv: move) {
                int x = cur[0];
                int y = cur[1];
                while (true) {
                    if (x+mv[0]>=0 && x+mv[0]<n && y+mv[1]>=0 && y+mv[1]<m) {
                        if (!visited[x+mv[0]][y+mv[1]] && map[x+mv[0]][y+mv[1]] == 0) {
                            //System.out.println(x +" " + y);
                            visited[x+mv[0]][y+mv[1]] = true;
                            newq.offer(new int[]{x+mv[0], y+mv[1]});
                            num--;
                        }
                        else if (map[x+mv[0]][y+mv[1]] == 1) {
                            break;
                        }
                        x += mv[0];
                        y += mv[1];
                    }
                    else {
                        break;
                    }
                }
                // for (int i=0; i<n; i++) {
                //     System.out.println(Arrays.toString(visited[i]));
                // }
            }
        }
        if (num > answer) {
            // System.out.println("=======================");
            // System.out.println(num);
            // for (int i=0; i<n; i++) {
            //     System.out.println(Arrays.toString(visited[i]));
            // } 
            // for (int i=0; i<n; i++) {
            //     System.out.println(Arrays.toString(map[i]));
            // } 
            answer = num;
        }
        return;
    }
}