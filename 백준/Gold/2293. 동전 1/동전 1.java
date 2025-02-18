import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int K;
	public static int[] coins;
	public static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		coins = new int[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i=0; i<N; i++) {
			//동전을 하나씩 추가함 
			for (int j=1; j<=K; j++) {
				//금액을 1원씩 올림
				if (j >= coins[i]) {
					//목표 금액이 추가된 동전보다 크면 (추가된 동전을 사용할 수 있으면)
					dp[j] = dp[j] + dp[j - coins[i]];
					// 추가된 동전 사용 전의 경우의 수 + 추가된 동전 사용한 경우의 수 
				}
			}
		}
		System.out.println(dp[K]);
	}
}