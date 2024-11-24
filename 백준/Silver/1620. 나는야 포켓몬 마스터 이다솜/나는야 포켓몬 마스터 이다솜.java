import java.io.*;
import java.util.*;

public class Main {
	
	public static class com implements Comparator<String[]> {
		@Override
		public int compare(String[] arr1, String[] arr2) {
			return arr1[0].compareTo(arr2[0]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] orgArr = new String[N];
		String[][] srtArr = new String[N][2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String lowStr = str.toLowerCase();
			orgArr[i] = str;
			srtArr[i][0] = lowStr;
			srtArr[i][1] = String.valueOf(i);
		}
		
		Arrays.sort(srtArr, new com());
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (Character.isDigit(str.charAt(0))) {
				int ix = Integer.parseInt(str) - 1;
				System.out.println(orgArr[ix]);
			}
			else {
				System.out.println(binarySearch(N, str.toLowerCase(), srtArr));
			}
			
		}
	}
	
	public static int binarySearch(int N, String target, String[][] srtArr) {
		int left = 0;
		int right = N-1;
		int mid;
		
		while (left <= right) {
			mid = (left+right)/2;
			String midStr = srtArr[mid][0];
			
			if (midStr.equals(target)) {
				return Integer.valueOf(srtArr[mid][1]) + 1;
			}
			
			//왼쪽 탐색 (중간값보다 타겟이 더 작음)
			else if (target.compareTo(midStr) < 0){
				right = mid - 1;
			}
			
			//오른쪽 탐색 
			else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
}