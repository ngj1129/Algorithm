import java.io.*;
import java.util.*;

public class Main {
	public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i=0; i<n; i++) {
			String[] strArr = new String(br.readLine()).split("");
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.valueOf(strArr[j]);
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println(bfs(n, m));
	}
	
	public static int bfs(int n, int m) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		queue.add(new int[] {0, 0, 1});
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curD = cur[2];
			
			if (curX == n-1 && curY == m-1) {
				return curD;
			}
			
			for (int[] mv: move) {
				int afterX = curX + mv[0];
				int afterY = curY + mv[1];
				if (afterX >= 0 && afterX < n && afterY >= 0 && afterY < m) {
					if (map[afterX][afterY] > 0 && !visited[afterX][afterY]) {
						queue.add(new int[] {afterX, afterY, curD+1});
						visited[afterX][afterY] = true;
					}
				}
			}
		}
		return 0;
	}
}