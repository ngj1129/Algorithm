import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int[] persons;
	public static ArrayList<ArrayList<Integer>> info;
	public static ArrayList<ArrayList<Integer>> town;
	public static int[][] dp;
	
	/*
	 * n이 우수 마을이 아닐 때 자식은 우수여도 되고 아니여도 됨
	 * 만약, 자식이 모두 우수가 아니고, 이 상황이 계속 반복돼서 
	 * 적어도 하나의 우수 마을과 인접해야 한다는 조건을 충족하지 않는다면?
	 * -> 최댓값을 구하는 것이기 때문에 그럴 일 없음 
	 * 
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		persons = new int[n+1];
		info = new ArrayList<>();
		town = new ArrayList<>();
		dp = new int[n+1][2];
		
		for (int i=0; i<n+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i=0; i<n+1; i++) {
			info.add(new ArrayList<Integer>());
			town.add(new ArrayList<Integer>());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<n+1; i++) {
			persons[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			info.get(t1).add(t2);
			info.get(t2).add(t1);
		}
		
//		for (int i=1; i<n+1; i++) {
//			ArrayList<Integer> list = info.get(i);
//			System.out.println(list);
//		}
		
		dfs(1, new boolean[n+1]);
		
//		for (int i=1; i<n+1; i++) {
//			ArrayList<Integer> list = town.get(i);
//			System.out.println(list);
//		}
		
		System.out.println(Math.max(getSum(1, 0), getSum(1, 1)));
	}
	
	public static int getSum(int cur, int isBest) {
		if (dp[cur][isBest] >= 0) {
			return dp[cur][isBest];
		}
		ArrayList<Integer> chList = town.get(cur);
		
		// cur이 우수 마을이면 
		if (isBest == 1) {
			dp[cur][1] = persons[cur];
			for (int child: chList) {
				dp[cur][1] += getSum(child, 0);
			}
		}
		// cur이 우수 마을이 아니면 
		else {
			dp[cur][0] = 0;
			for (int child: chList) {
				dp[cur][0] += Math.max(getSum(child, 1), getSum(child, 0));
			}
		}
		return dp[cur][isBest];
	}
	
	public static void dfs(int cur, boolean[] visited) {
		visited[cur] = true;
		
		ArrayList<Integer> adjList = info.get(cur);
		
		for (int next: adjList) {
			if (!visited[next]) {
				town.get(cur).add(next);
				dfs(next, visited);
			}
		}
	}
}