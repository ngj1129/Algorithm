import java.io.*;
import java.util.*;
 
public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);	
		
		
		int lo = 1;		
		int hi = arr[N-1] - arr[0] + 1;	//초과값 찾는 것이므로 최대거리에 +1 해준다 
		
		//이상 ~ 미만 
		while(lo < hi) {	
			
			int mid = (hi + lo) / 2;
			
			
			if(check(mid) < M) {
				hi = mid;
			}
			
			else { // 같으면 더 큰 거리 해본다 (오른쪽 확인) 
				lo = mid + 1;
			}
		}
		

		//upper bound 이므로 초과값이 나온다. 그래서 1 빼줘야 함 
		System.out.println(lo - 1);
	}
	
	public static int check(int minD) {
		
		int count = 1;
		int last = arr[0];
		
		for(int i=1; i <arr.length; i++) {
			
			if(arr[i] - last >= minD) {
				count++;
				last = arr[i];
			}
		}
		return count;
		
	}
		
}