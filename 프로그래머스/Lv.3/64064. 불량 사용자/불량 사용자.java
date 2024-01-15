import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    int result = 0;
    ArrayList<String[]> list = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {
        perm(banned_id, banned_id.length, new String[banned_id.length], new boolean[banned_id.length], 0);
        dfs(user_id, banned_id, banned_id.length, new String[banned_id.length], 0, 0);
        return result;
    }
    public void perm(String[] banned_id, int r, String[] out, boolean[] visited, int depth) {
        if (depth == r) {
            list.add(Arrays.copyOf(out, out.length));
            return;
        }
        for (int i=0; i<banned_id.length; i++) {
            if (!visited[i]) {
                out[depth] = banned_id[i];
                visited[i] = true;
                perm(banned_id, r, out, visited, depth+1);
                visited[i] =false;
            }
        }
    }
    public void dfs(String[] user_id, String[] banned_id, int r, String[] out, int start, int depth) {
        if (depth == r) {
            for (int ix=0; ix<list.size(); ix++) {
                String[] arr = list.get(ix);
                boolean check = false;
                for (int i=0; i<r; i++) {
                    if (out[i].length() != arr[i].length()) {
                        check = true;
                        continue;
                    }
                    for (int j=0; j<out[i].length(); j++) {
                        if (arr[i].charAt(j) != '*' && out[i].charAt(j) != arr[i].charAt(j)) {
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
                if (!check) {
                    result++;
                    break;
                }
            }
            return;
        }
        for (int i=start; i<user_id.length; i++) {
            out[depth] = user_id[i];
            dfs(user_id, banned_id, r, out, i+1, depth+1);
        }
    }
}