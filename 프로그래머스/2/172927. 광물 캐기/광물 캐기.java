import java.util.Arrays;
import java.util.HashMap;

class Solution {
    int answer = 1500;
    public int solution(int[] picks, String[] minerals) {
        HashMap<String, Integer> min_pic = new HashMap<>();
        min_pic.put("diamond", 1);
        min_pic.put("iron", 5);
        min_pic.put("stone", 25);
        int[] dic = {1, 5, 25};
        int n = 0;
        for (int num: picks) {
            n += num;
        }
        perm(picks, new int[n], n, 0, minerals, min_pic, dic);
        return answer;
    }
    public void perm(int[] picks, int[] out, int n, int depth, String[] minerals, HashMap<String, Integer> min_pic, int[] dic) {
        if (depth == n) {
            int ip = 0;
            int im = 0;
            int tmp = 0;
            int count = 0;
            while (ip < n) {
                if (im >= minerals.length) {
                    break;
                }
                if (count == 5) {
                    ip++;
                    count = 0;
                    continue;
                }
                int m = min_pic.get(minerals[im]);
                tmp += Math.max(out[ip]/m, 1);
                count++;
                im++;
            }
            if (tmp < answer) {
                answer = tmp;
            }
            return;
        }
        for (int i=0; i<3; i++) {
            if (picks[i] > 0) {
                out[depth] = dic[i];
                picks[i]--;
                perm(picks, out, n, depth+1, minerals, min_pic, dic);
                picks[i]++;
            }
        }
    }
}