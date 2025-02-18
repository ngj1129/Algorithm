import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] sums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			sum += arr[n];
			sums[n+1] = sum;
		}
		
//		System.out.println(Arrays.toString(sums));
		
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(sums[j]-sums[i-1]);
		}
	}
}