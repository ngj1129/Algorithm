import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> honor = new ArrayList<>();
        int[] result = new int[score.length];
        for (int i=0; i<score.length; i++) {
            if (i < k) {
                honor.add(score[i]);
                Collections.sort(honor);
            }
            else {
                if (score[i] > honor.get(0)){
                    honor.remove(0);
                    honor.add(score[i]);
                    Collections.sort(honor);
                } 
            }
            result[i] = honor.get(0);
        }
        return result;
    }
}