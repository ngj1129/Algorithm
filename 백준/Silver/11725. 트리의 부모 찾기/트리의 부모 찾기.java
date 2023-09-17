import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] node = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) {
                list = map.get(a);
                list.add(b);
                map.put(a, list);
            } else {
                list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
            }
            if (map.containsKey(b)) {
                list = map.get(b);
                list.add(a);
                map.put(b, list);
            } else {
                list = new ArrayList<>();
                list.add(a);
                map.put(b, list);
            }
        }
        boolean[] v = new boolean[n+1];
        v[1] = true;
        q.offer(1);
        int parent = 0;
        int child = 0;
        while (!q.isEmpty()) {
            parent = q.poll();
            list = map.get(parent);
            for (int i=0; i<list.size(); i++) {
                child = list.get(i);
                if (!v[child]) {
                    node[child] = parent;
                    v[child] = true;
                    q.offer(child);
                }
            }
        }
        for (int i=2; i<node.length; i++) {
            System.out.println(node[i]);
        }
    }
}