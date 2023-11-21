import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for (int i=0; i<triangle.length; i++) {
            dp[i] = new int[i+1];
        }
        for (int i=triangle.length-1; i>0; i--) {
            for (int j=0; j<=i; j++) {
                dp[i][j] += triangle[i][j];
            }
            for (int j=0; j<i; j++) {
                dp[i-1][j] = Math.max(dp[i][j], dp[i][j+1]);
            }
        }
        
        return dp[0][0] + triangle[0][0];
    }
}