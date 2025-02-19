import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] dp;
	public static String[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		nums = new String[N+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		nums[0] = new String("");
		nums[1] = new String("");
		
		//dp[1] = 0 
		//dp[n] = Math.min(dp[n], 1 + dp[n/3])
		//dp[n] = 1 + dp[n/2]
		
		System.out.println(recursion(N));
		System.out.println(N + " " + nums[N]);
		
	}
	
	public static int recursion(int num) {
		if (dp[num] < Integer.MAX_VALUE) {
			return dp[num];
		}
		
		if (num % 3 == 0) {
			if (recursion(num/3) + 1 < dp[num]) {
				dp[num] = recursion(num/3) + 1;
				nums[num] = new String((num/3) + " " + nums[num/3]);
			}
		}
		if (num % 2 == 0) {
			if (recursion(num/2) + 1 < dp[num]) {
				dp[num] = recursion(num/2) + 1;
				nums[num] = new String((num/2) + " " + nums[num/2]);
			}
		}
		if (recursion(num-1) + 1 < dp[num]) {
			dp[num] = recursion(num-1) + 1;
			nums[num] = new String((num-1) + " " + nums[num-1]);
		}
		return dp[num];
	}
}