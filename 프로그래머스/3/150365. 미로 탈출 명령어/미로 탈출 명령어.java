import java.util.*;

class Solution {
    public int[] dx = {1, 0, 0, -1};
    public int[] dy = {0, -1, 1, 0};

    public class Point {
        public int x, y;
        public StringBuilder sb;

        public Point(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }

    public char convertDir(int d) {
        if (d == 0) return 'd';
        if (d == 1) return 'l';
        if (d == 2) return 'r';
        if (d == 3) return 'u';
        return '0';
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] chk = new boolean[n][m][k+1];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x-1, y-1, new StringBuilder()));
        chk[x-1][y-1][0] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == r-1 && cur.y == c-1) {
                if (cur.sb.toString().length() == k)
                    return cur.sb.toString();
            }
            if (cur.sb.toString().length() == k)
                continue;

            for (int d = 0; d < 4; d++) {
                int X = cur.x + dx[d];
                int Y = cur.y + dy[d];
                if (X < 0 || Y < 0 || X >= n || Y >= m || chk[X][Y][cur.sb.toString().length() + 1])
                    continue;
                chk[X][Y][cur.sb.toString().length() + 1] = true;
                q.add(new Point(X, Y, new StringBuilder(cur.sb).append(convertDir(d))));
            }
        }
        return "impossible";
    }
}

// import java.util.Queue;
// import java.util.LinkedList;
// import java.util.HashMap;
// import java.util.Arrays;
// import java.util.ArrayList;

// class Solution {
//     public HashMap<String, int[]> map = new HashMap<>();
//     public String[] direction = {"d", "l", "r", "u"};
//     public int[][] move = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
//     public int min_path;
    
//     public String solution(int n, int m, int x, int y, int r, int c, int k) {
//         min_path = Math.abs(r-x) + Math.abs(c-y);
//         for (int i=0; i<4; i++) {
//             map.put(direction[i], move[i]);
//         }
//         Queue<int[]> q = new LinkedList<>();
//         Queue<String> path = new LinkedList<>();
//         boolean[][] visited = new boolean[n][m];
//         q.offer(new int[] {x-1, y-1, 0});
//         path.offer("");
//         visited[x-1][y-1] = true;
//         if (k < min_path | (k-min_path)%2 != 0) {
//             return "impossible";
//         }
//         return bfs(n, m, r, c, k, q, path);
//     }

//     public String bfs(int n, int m, int r, int c, int k, Queue<int[]> q, Queue<String> path) {
//         while (!q.isEmpty()) {
//             int[] pop = q.poll();
//             String s = path.poll();
//             int x = pop[0];
//             int y = pop[1];
//             int d = pop[2];
//             if (d == k) {
//                 if (x+1 == r && y+1 == c) {
//                     return s;
//                 }
//                 continue;
//             }
//             for (String dir: direction) {
//                 int[] mv = map.get(dir);
//                 StringBuilder sb = new StringBuilder(s);
//                 if (x+mv[0] >= 0 && x+mv[0] < n && y+mv[1] >= 0 && y+mv[1] < m) {
//                     if (k-d < Math.abs(x+mv[0]-(r-1)) + Math.abs(y+mv[1]-(c-1))) {
//                         continue;
//                     }
//                     q.offer(new int[]{x+mv[0], y+mv[1], d+1});
//                     sb.append(dir);
//                     path.offer(sb.toString());
//                 }
//             }  
//         }
//         return "impossible";
//     }
// }