import java.util.Arrays;

class Solution {
    long[][] dp = new long[100][100];
    boolean[][] visited = new boolean[100][100];
    public int solution(int m, int n, int[][] puddles) {
        visited[0][0] = true;
        for (int[] puddle: puddles) {
            visited[puddle[1]-1][puddle[0]-1] = true;
        }
        boolean check = false;
        for (int ix=1; ix<100; ix++) {
            if (check) {
                visited[ix][0] = true;
                continue;
            }
            if (visited[ix][0]) {
                check = true;
            }
        }
        check = false;
        for (int iy=1; iy<100; iy++) {
            if (check) {
                visited[0][iy] = true;
                continue;
            }
            if (visited[0][iy]) {
                check = true;
            }
        }
        return (int) recursion(n-1, m-1) % 1000000007;
    }
    
    public long recursion(int x, int y) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            if (x == 0 | y == 0) {
                dp[x][y] = 1;
            }
            else {
                dp[x][y] = recursion(x-1, y) % 1000000007 + recursion(x, y-1) % 1000000007;
            }
        }
        return dp[x][y];
    }
}