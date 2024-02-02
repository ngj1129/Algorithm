import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] edge) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] arr: edge) {
            if (map.containsKey(arr[0])) {
                list = map.get(arr[0]);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(arr[1]);
            map.put(arr[0], list);
            
            if (map.containsKey(arr[1])) {
                list = map.get(arr[1]);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(arr[0]);
            map.put(arr[1], list);
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(new int[]{1, 0});
        visited[1] = true;
        return bfs(map, q, visited);
    }
    
    public int bfs(HashMap<Integer, ArrayList<Integer>> map, Queue<int[]> q, boolean[] visited) {
        int result = 0;
        int far = 0;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int node = arr[0];
            int d = arr[1];
            ArrayList<Integer> list = map.get(node);
            boolean check = false;
            for (int i=0; i<list.size(); i++) {
                if (!visited[list.get(i)]) {
                    check = true;
                    q.offer(new int[]{list.get(i), d+1});
                    visited[list.get(i)] = true;
                }
            }
            if (!check) {
                if (d > far) {
                    result = 1;
                    far = d;
                }
                else if (d == far) {
                    result++;
                }
            }
        }
        return result;
    }
}