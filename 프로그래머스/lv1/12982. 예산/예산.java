import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int result = 0;
        for (int i: d) {
            if (budget < i)
                return result;
            budget -= i;
            result++;
        }
        return result;
    }
}