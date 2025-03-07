import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int maxSum = 0;
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	dp[i] = arr[i];
        }
        
        for (int i=1; i<n; i++) {
        	for (int j=0; j<i; j++) {
        		if (arr[i] > arr[j]) {
        			dp[i] = Math.max(dp[i], dp[j]+arr[i]);
        		}
        	}
        }
        
        for (int i=0; i<n; i++) {
        	maxSum = Math.max(maxSum, dp[i]);
        }
        
        System.out.println(maxSum);
    }
}