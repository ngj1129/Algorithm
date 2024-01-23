import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int[] road: roads) {
            road[0]--;
            road[1]--;
            if (map.containsKey(road[0])) {
                list = map.get(road[0]);
                list.add(road[1]);
                map.put(road[0], list);
            }
            else {
                list = new ArrayList<>();
                list.add(road[1]);
                map.put(road[0], list);
            }
            if (map.containsKey(road[1])) {
                list = map.get(road[1]);
                list.add(road[0]);
                map.put(road[1], list);
            }
            else {
                list = new ArrayList<>();
                list.add(road[0]);
                map.put(road[1], list);
            }
        }
        int[] result = new int[sources.length];
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = -1;
        }
        arr[destination-1] = 0;
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{destination-1, 0});
        visited[destination-1] = true;
        bfs(arr, visited, map, q);
        //System.out.println(Arrays.toString(arr));
        for (int i=0; i<sources.length; i++) {
            result[i] = arr[sources[i]-1]; 
        }
        return result;
    }
    
    public void bfs(int[] arr, boolean[] visited, HashMap<Integer, ArrayList<Integer>> map, Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int node = tmp[0];
            int d = tmp[1];
            ArrayList<Integer> list = map.get(node);
            for (int i=0; i<list.size(); i++) {
                if (!visited[list.get(i)]) {
                    q.offer(new int[]{list.get(i), d+1});
                    arr[list.get(i)] = d+1;
                    visited[list.get(i)] = true;
                }
            }
        }
        return;
    }
    
    
}