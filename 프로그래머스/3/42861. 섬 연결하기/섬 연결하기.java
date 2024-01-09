import java.util.Arrays;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int result = 0;
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        for (int i=0; i<costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                result += costs[i][2];
            }
        }
        return result;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        }
        else {
            parent[b] = a;
        }
    }
    
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        else {
            return find(parent[x]);
        }
    }
}