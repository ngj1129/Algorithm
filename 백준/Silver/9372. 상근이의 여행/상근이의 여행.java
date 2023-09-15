import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (map.containsKey(a)) {
                    list = map.get(a);
                } else {
                    list = new ArrayList<>();
                }
                list.add(b);
                map.put(a, list);
                if (map.containsKey(b)) {
                    list = map.get(b);
                } else {
                    list = new ArrayList<>();
                }
                list.add(a);
                map.put(b, list);
            }
            bfs(map, visited, q);

        }
    }

    public static void bfs(HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, Queue<Integer> q) {
        int ct = -1;
        int state = 1;
        q.offer(state);
        visited[state] = true;

        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            state = q.poll();
            ct++;
            list = map.get(state);
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    q.offer(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
        }
        System.out.println(ct);
    }
}