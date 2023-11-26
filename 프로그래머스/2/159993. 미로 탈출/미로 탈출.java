import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        for (int i=0; i<maps.length; i++) {
            map[i] = maps[i].split("");
        }
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        int r1 = 0;
        int r2 = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
                if (map[i][j].equals("L")) {
                    lever[0] = i;
                    lever[1] = j;
                }
                if (map[i][j].equals("E")) {
                    exit[0] = i;
                    exit[1] = j;
                }
            } 
        }
        q.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;
        r1 = bfs(map, q, visited, lever);
        if (r1 == -1) {
            return -1;
        }
        q = new LinkedList<>();
        q.offer(new int[]{lever[0], lever[1], 0});
        visited = new boolean[map.length][map[0].length];
        visited[lever[0]][lever[1]] = true;
        r2 = bfs(map, q, visited, exit);
        if (r2 == -1) {
            return -1;
        }
        return r1 + r2;
    }
    public int bfs(String[][] map, Queue<int[]> q, boolean[][] visited, int[] goal) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1]; 
            int d = cur[2];
            if (x == goal[0] && y == goal[1]) {
                return d;
            }
            for (int[] mv: move) {
                if (x+mv[0] >= 0 && x+mv[0] < map.length && y+mv[1] >= 0 && y+mv[1] < map[0].length) {
                    if (!map[x+mv[0]][y+mv[1]].equals("X") && !visited[x+mv[0]][y+mv[1]]) {
                        q.offer(new int[]{x+mv[0], y+mv[1], d+1});
                        visited[x+mv[0]][y+mv[1]] = true;
                    }
                }
            }
        }
        return -1;
    }
}