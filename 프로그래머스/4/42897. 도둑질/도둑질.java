import java.util.Arrays;

class Solution {
    public int solution(int[] money) {
        int len = money.length;
		int[][] dp = new int[2][len];
		dp[0][0] = money[0];
		dp[0][1] = money[0];
		dp[1][0] = 0;
		dp[1][1] = money[1];
		
		for(int i=2; i<len ; i++) {
			dp[0][i] = Math.max(dp[0][i-2]+money[i], dp[0][i-1]);
			dp[1][i] = Math.max(dp[1][i-2]+money[i], dp[1][i-1]);
		}
		
		return Math.max(dp[0][len-2], dp[1][len-1]);
    }
}
/*
class Solution {
    public int solution(int[] money) {
        int[][] dp = new int[money.length][money.length];
        for (int i=0; i<money.length; i++) {
            dp[i][i] = money[i];
            if (i < money.length-1) {
                dp[i][i+1] = Math.max(money[i], money[i+1]);
            }
        }
        
        if (money.length == 3) {
            return Math.max(dp[0][1], dp[1][2]);
        }
        dp[0][2] = Math.max(money[0]+money[2], money[1]);
        
        for (int i=3; i<money.length; i++) {
            dp[0][i] = Math.max(money[i]+dp[1][i-2], dp[0][i-1]);
        }
        
        return dp[0][money.length-1];
    }
}
*/