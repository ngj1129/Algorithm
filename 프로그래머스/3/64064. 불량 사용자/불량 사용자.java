import java.util.*;

class Solution {
    int answer = 0;
    boolean flag = false;
    
    public int solution(String[] user_id, String[] banned_id) {
        int n = user_id.length;
        int m = banned_id.length;

        com(user_id, banned_id, new String[m], n, m, 0, 0);
        
        return answer;
    }
    
    public void perm(String[] arr, String[] out, boolean[] visited, String[] target, int m, int depth) {
        if (depth == m) {
            // System.out.println(Arrays.toString(out));
            if (check(out, target)) {
                flag = true;
            }
            return;
        }
        for (int i=0; i<m; i++) {
            if (!visited[i]) {
                out[depth] = arr[i];
                visited[i] = true;
                perm(arr, out, visited, target, m, depth+1);
                visited[i] = false;
            }
        }
    }
    
    public void com(String[] arr, String[] target, String[] out, int n, int m, int ix, int depth) {
        if (depth == m) {
            // System.out.println(Arrays.toString(out));
            perm(out, new String[m], new boolean[m], target, m, 0);
            if (flag) {
                answer++;
                flag = false;
            }
            return;
        }
        for (int i=ix; i<n; i++) {
            out[depth] = arr[i];
            com(arr, target, out, n, m, i+1, depth+1);
        }
    }
    
    public boolean check(String[] out, String[] target) {
        for (int i=0; i<out.length; i++) {
            // System.out.println(out[i] + ", " + target[i]);
            String[] arr1 = out[i].split("");
            String[] arr2 = target[i].split("");
            
            if (arr1.length != arr2.length) {
                return false;
            }
            
            for (int j=0; j<arr1.length; j++) {
                if (!arr2[j].equals("*") && !arr1[j].equals(arr2[j])) {
                    // System.out.println(out[i] + ", " + target[i]);
                    return false;
                }
            }
        }
        return true;
    }
    
}