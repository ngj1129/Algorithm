import java.util.*;

class Solution {
    int n = 0;
    int newNode = 0;
    int donutCount = 0;
    int stickCount = 0;
    int eightCount = 0;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int[] solution(int[][] edges) {
        ArrayList<Integer> newNodeCandidates = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] arr : edges) {
            n = Math.max(n, arr[0]);
            n = Math.max(n, arr[1]);
        }
        boolean[] visited = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            ArrayList<Integer> list = graph.get(arr[0]);
            list.add(arr[1]);
            set.add(arr[1]);
            if (list.size() == 2) {
                newNodeCandidates.add(arr[0]);
            }
            if (list.size() > 2) {
                newNode = arr[0];
                // break;
            }
        }
        if (newNode == 0) {
            for (int candidate : newNodeCandidates) {
                if (!set.contains(candidate)) {
                    newNode = candidate;
                    break;
                }
            }
        }
        // System.out.println(graph);
        // System.out.println(newNode);
        // System.out.println(newNode);
        visited[newNode] = true;
        ArrayList<Integer> list = graph.get(newNode);
        for (int i=0; i<list.size(); i++) {
            int start = list.get(i);
            findShape(start, visited);
        }
        return new int[]{newNode, donutCount, stickCount, eightCount};
        
        // return new int[]{};
    }
    
    public void findShape(int start, boolean[] visited) {
        // System.out.println(Arrays.toString(visited));
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start] = true;
        int nodeCount = 1;
        int edgeCount = 0;
        
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            ArrayList<Integer> list = graph.get(cur);
            for (int i=0; i<list.size(); i++) {
                int next = list.get(i);
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                    nodeCount++;
                }
                edgeCount++;
            }
        }
        
        if (nodeCount == edgeCount) {
            donutCount++;
        }
        if (nodeCount - 1 == edgeCount) {
            stickCount++;
        }
        if (nodeCount+1 == edgeCount) {
            eightCount++;
        }
    }
}