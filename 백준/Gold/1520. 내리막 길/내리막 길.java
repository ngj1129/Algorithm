import java.io.*;
import java.util.*;

public class Main {
	
	public static final int INF = 10001;
	public static int[][] map;
	public static ArrayList<ArrayList<Node>> nodeMap;
//	public static int[][] dir;
//	public static ArrayList<ArrayList<ArrayList<Integer>>> list;
	public static int[][] dp;
	public static int M;
	public static int N;
	public static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			
	public static class Node {
		public int x;
		public int y;
		public int dir;
		public ArrayList<Integer> dirs; 
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			dir = 0;
			dirs = new ArrayList<Integer>();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
//		dir = new int[M][N];
		dp = new int[M][N];
		nodeMap = new ArrayList<ArrayList<Node>>();
		
		for (int i=0; i<M; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<M; i++) {
			ArrayList<Node> list = new ArrayList<>();
			for (int j=0; j<N; j++) {
				list.add(new Node(i, j));
			}
			nodeMap.add(list);
		}
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				int cur = map[i][j];
				Node curNode = nodeMap.get(i).get(j);
				for (int d=0; d<4; d++) {
					int afterX = i+move[d][0];
					int afterY = j+move[d][1];
					if (afterX >= 0 && afterX < M && afterY >= 0 && afterY < N) {
						int after = map[afterX][afterY];
						if (cur > after) {
							curNode.dir++;
							curNode.dirs.add(d);
						}
					}
				}
			}
		}
		
		countPath(0, 0);
		System.out.println(dp[0][0]);
	}
	
	public static int countPath(int x, int y) {
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		
		if (x == M-1 && y == N-1) {
			return 1;
		}
		
		Node node = nodeMap.get(x).get(y);
		
		dp[x][y] = 0;
		
		if (node.dir == 1) {
			int d = node.dirs.get(0);
			dp[x][y] = countPath(x+move[d][0], y+move[d][1]);
		}
		else if (node.dir > 1) {
			ArrayList<Integer> dirs = node.dirs;
			for (int i=0; i<dirs.size(); i++) {
				int d = dirs.get(i);
				dp[x][y] += countPath(x+move[d][0], y+move[d][1]);
			}
		}
		
		return dp[x][y];
	}
}