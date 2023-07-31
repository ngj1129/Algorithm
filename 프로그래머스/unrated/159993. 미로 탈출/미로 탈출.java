import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        for (int i=0; i<maps.length; i++)
            map[i] = maps[i].split("");
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        int l = 0;
        int e = 0;
        
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j].equals("S")) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    l = bfs(map, visited, q, "L");
                }
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        q = new LinkedList<>();
        
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j].equals("L")) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    e = bfs(map, visited, q, "E");
                }
            }
        }
        if (l==-1 | e==-1)
            return -1;
        return l+e;
    }
    
    public int bfs(String[][] map, boolean[][] visited, Queue<int[]> q, String goal) {
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int dist = xy[2];
            if (map[x][y].equals(goal))
                return xy[2];
            for (int[] mv: move) {
                int mx = mv[0];
                int my = mv[1];
                if (x+mx>=0 && x+mx<map.length && y+my>=0 && y+my<map[0].length && !map[x+mx][y+my].equals("X") && !visited[x+mx][y+my]) {
                    q.offer(new int[]{x+mx, y+my, dist+1});
                    visited[x+mx][y+my] = true;
                }
            }
        }
        return -1;
    }
}