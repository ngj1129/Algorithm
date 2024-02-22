import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] target1, int[] target2) {
                return target1[1] - target2[1];
            }
        });
        
        int missile = Integer.MIN_VALUE;
        
        for(int[] target : targets) {
            if(missile <= target[0]) {
                missile = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}