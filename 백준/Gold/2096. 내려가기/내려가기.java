import java.io.*;
import java.util.*;

public class Main {
	public static int[][] dpMax;
	public static int[][] dpMin;
	public static int[][] graph;
	public static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		dpMax = new int[n][3];
		dpMin = new int[n][3];
		graph = new int[n][3];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dpMax[i], -1);
			Arrays.fill(dpMin[i], Integer.MAX_VALUE);
		}
		
		dpMax[n-1][0] = graph[n-1][0];
		dpMax[n-1][1] = graph[n-1][1];
		dpMax[n-1][2] = graph[n-1][2];
		dpMin[n-1][0] = graph[n-1][0];
		dpMin[n-1][1] = graph[n-1][1];
		dpMin[n-1][2] = graph[n-1][2];
		
		System.out.print(Math.max(Math.max(getMax(0, 0), getMax(0, 1)), getMax(0, 2)) + " ");
		System.out.println(Math.min(Math.min(getMin(0, 0),getMin(0, 1)), getMin(0, 2)));
		
	}
	
	public static int getMax(int cur, int curIx) {
		if (dpMax[cur][curIx] >= 0) {
			return dpMax[cur][curIx];
		}
		
		for (int i=-1; i<2; i++) {
			int nextIx = curIx + i;
			if (nextIx >= 0 && nextIx < 3) {
				dpMax[cur][curIx] = Math.max(getMax(cur+1, nextIx)+graph[cur][curIx], dpMax[cur][curIx]);
			}
		}
		return dpMax[cur][curIx];
	}
	
	public static int getMin(int cur, int curIx) {
		if (dpMin[cur][curIx] < Integer.MAX_VALUE) {
			return dpMin[cur][curIx];
		}
		
		for (int i=-1; i<2; i++) {
			int nextIx = curIx + i;
			if (nextIx >= 0 && nextIx < 3) {
				dpMin[cur][curIx] = Math.min(getMin(cur+1, nextIx)+graph[cur][curIx], dpMin[cur][curIx]);
			}
		}
		return dpMin[cur][curIx];
	}
}