import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    bfs(n, i, visited, computers);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void bfs(int n, int startX, boolean[][] visited, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        while (!queue.isEmpty()) {
            int curX = queue.poll();
            for (int i=0; i<n; i++) {
                if (!visited[curX][i] && computers[curX][i] == 1) {
                    visited[i][curX] = true;
                    visited[curX][i] = true;
                    queue.add(i);
                }
            }
        }
    }
}