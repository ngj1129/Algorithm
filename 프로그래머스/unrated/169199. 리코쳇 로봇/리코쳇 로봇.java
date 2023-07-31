import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
class Solution {
    private int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                            
    public int solution(String[] board) {
        String[][] gp = new String[board.length][board[0].length()];
        for (int i=0; i<board.length; i++) 
            gp[i] = board[i].split("");
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> q = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for (int i=0; i<gp.length; i++) {
            for (int j=0; j<gp[0].length; j++) {
                if (gp[i][j].equals("R")) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    map.put(i+""+j, "0");
                    return bfs(gp, visited, q, map);
                }
            }
        }
        return 0;
    }
    public int bfs(String[][] gp, boolean[][] visited, Queue<int[]> q, HashMap<String, String> map) {
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            if (gp[xy[0]][xy[1]].equals("G")) {
                int answer = 0;
                String parent = map.get(xy[0]+""+xy[1]);
                while (!parent.equals("0")) {
                    parent = map.get(parent);
                    answer++;
                }
                return answer;
            }
            for (int[] mv: move) {
                boolean check = true;
                int mx = mv[0];
                int my = mv[1];
                int x = xy[0];
                int y = xy[1];
                while (x+mx>=0 && x+mx<gp.length && y+my>=0 && y+my<gp[0].length && !gp[x+mx][y+my].equals("D")) {
                        x += mx;
                        y += my;
                    }
                if (x != xy[0] | y != xy[1] && !visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                    map.put(x+""+y, xy[0]+""+xy[1]);
                }
            }
        }
        return -1;
    }
                           
}