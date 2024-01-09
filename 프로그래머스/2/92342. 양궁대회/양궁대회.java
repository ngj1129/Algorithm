import java.util.Arrays;

class Solution {
    int diff = 0;
    int[] win = new int[11];
    int[] lose = {-1};
    public int[] solution(int n, int[] info) {
        dfs(n, info, new int[11], 0, 0);
        if (diff == 0) {
            return lose;
        }
        return win;
    }
    
    public void dfs(int n, int[] info, int[] lion, int start, int depth) {
        if (depth > n) {
            return;
        }
        if (depth == n) {
            //System.out.println(Arrays.toString(lion));
            int p = 0;
            int l = 0;
            boolean check = false;
            for (int i=0; i<11; i++) {
                if (info[i] > 0 && info[i] >= lion[i]) {
                    p += 10-i;
                }
                else if (lion[i] > info[i]) {
                    l += 10-i;
                }
            }
            if (l > p && l-p >= diff) {
                if (l-p == diff) {
                    for (int i=10; i>=0; i--) {
                        if (lion[i] > win[i]) {
                            break;
                        }
                        else if (lion[i] < win[i]) {
                            check = true;
                            break;
                        }
                    }
                }
                if (!check) {
                    diff = l-p;
                    for (int i=0; i<11; i++) {
                        win[i] = lion[i];
                    }
                }
            }
            return;
        }
        for (int i=start; i<11; i++) {
            if (i == 10) {
                lion[i] = n-depth;
            }
            else {
                lion[i] = info[i]+1;
            }
            dfs(n, info, lion, i+1, depth+lion[i]);
            lion[i] = 0;
        }
    }
}