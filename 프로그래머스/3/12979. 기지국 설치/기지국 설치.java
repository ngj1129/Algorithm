import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w*2 + 1;
        ArrayList<Integer> list = new ArrayList<>();
        int start = 1;
        for (int i=0; i<stations.length; i++) {
            // System.out.println(start);
            int ix = stations[i];
            int len = ix - w - start;
            if (len > 0) {
                if (len % range == 0) {
                    answer += len/range;
                }
                else {
                    answer += (len/range + 1);
                }
            }
            start = ix + w + 1;
        }
        // System.out.println(start);
        if (start <= n) {
            int len = n - start + 1;
            // System.out.println(len);
            if (len % range == 0) {
                answer += len/range;
            }
            else {
                answer += (len/range + 1);
            }
        }
        // System.out.println(list);
        // System.out.println(Arrays.toString(visited));
    
        return answer;
    }
}