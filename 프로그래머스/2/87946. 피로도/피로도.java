class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, new boolean[dungeons.length], 0, 0);
        return answer;
    }
    public void dfs(int k, int[][] dungeons, boolean[] visited, int cnt, int depth) {
        if (depth == dungeons.length) {
            if (cnt > answer) {
                answer = cnt;
            }
        }
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (k >= dungeons[i][0]) {
                    dfs(k-dungeons[i][1], dungeons, visited, cnt+1, depth+1);
                }
                else {
                    dfs(k, dungeons, visited, cnt, depth+1);
                }
                visited[i] = false;
            }
        }
    }
}