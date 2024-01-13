import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    ArrayList<String[]> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        for (int i=0; i<tickets.length; i++) {
            boolean[] visited = new boolean[tickets.length];
            String[] path = new String[tickets.length+1];
            path[0] = "ICN";
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                dfs(tickets, visited, path, tickets[i][1], 1);
            }
        }
        String[][] arr = new String[list.size()][list.get(0).length];
        for (int i=0; i<arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] arr1, String[] arr2) {
                for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
                    int result = arr1[i].compareTo(arr2[i]);
                    if (result != 0) {
                        return result;
                    }
                }
                return Integer.compare(arr1.length, arr2.length);
            }
        });
        return arr[0];
    }
    public void dfs(String[][] tickets, boolean[] visited, String[] path, String airport, int depth) {
        if (depth == tickets.length) {
            list.add(Arrays.copyOf(path, path.length));
            return;
        }
        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(airport)) {
                visited[i] = true;
                path[depth] = tickets[i][0];
                if (depth == tickets.length-1) {
                    path[depth+1] = tickets[i][1];
                }
                dfs(tickets, visited, path, tickets[i][1], depth+1);
                visited[i] = false;
            }
        }
    }
}