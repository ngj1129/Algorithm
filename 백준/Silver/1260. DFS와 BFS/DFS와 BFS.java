import java.io.*;
import java.util.*;

public class Main {
	
	public static ArrayList<ArrayList<Integer>> graph;
	public static int N;
	public static int M;
	public static int V;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		for (int i=1; i<=N; i++) {
			Collections.sort(graph.get(i));
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs(V, new boolean[N+1], new LinkedList<Integer>());
		
	}
	
	public static void dfs(int cur, boolean[] visited) {
		System.out.print(cur + " ");
		visited[cur] = true;
		
		ArrayList<Integer> list = graph.get(cur);
		
		for (int i=0; i<list.size(); i++) {
			if (!visited[list.get(i)]) {
				dfs(list.get(i), visited);
			}
		}
	}
	
	public static void bfs(int start, boolean[] visited, Queue<Integer> queue) {
		visited[start] = true;
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			ArrayList<Integer> list= graph.get(cur);
			
			for (int i=0; i<list.size(); i++ ) {
				if (!visited[list.get(i)]) {
					queue.add(list.get(i));
					visited[list.get(i)] = true;
				}
			}
		}
	}

}