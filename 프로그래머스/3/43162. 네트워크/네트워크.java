import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        int[][] node = new int[n][];
        for (int i=0; i<n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0; j<n; j++) {
                if (i != j) {
                    if (computers[i][j] == 1) {
                        list.add(j);
                    }
                }
            }
            node[i] = new int[list.size()];
            for (int ix=0; ix<list.size(); ix++) {
                node[i][ix] = list.get(ix);
            }
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                for (int j=0; j<node[i].length; j++) {
                    q.offer(node[i][j]);
                    visited[node[i][j]] = true;
                }
                while (!q.isEmpty()) {
                    int nd = q.poll();
                    for (int j=0; j<node[nd].length; j++) {
                        if (!visited[node[nd][j]]) {
                            q.offer(node[nd][j]);
                            visited[node[nd][j]] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}