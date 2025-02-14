import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] dp;
	public static int[][] house;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		dp = new int[N+1][3];
		house = new int[N+1][3];
		
		for (int i=0; i<=N; i++) {
			dp[i][0] = -1;
			dp[i][1] = -1;
			dp[i][2] = -1;
		}
		
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[0][2] = 0;
		
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}