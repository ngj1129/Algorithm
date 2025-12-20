class Solution {
    public static int[][] dp;
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        dp = new int[n][triangle[n-1].length];
        for (int i=0; i<n; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return recursion(triangle, 0, 0);
    }
    
    public int recursion(int[][] triangle, int row, int col) {
        if (dp[row][col] >= 0) {
            return dp[row][col];
        }
        if (row == triangle.length - 1) {
            dp[row][col] = triangle[row][col];
            return triangle[row][col];
        }
        
        dp[row][col] = triangle[row][col] + Math.max(recursion(triangle, row+1, col), recursion(triangle, row+1, col+1));
        
        return dp[row][col];
    }
}