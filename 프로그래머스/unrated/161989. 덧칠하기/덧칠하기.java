class Solution {
    public int solution(int n, int m, int[] section) {
        int max = 0;
        int result = 0;
        for (int s: section) {
            if (s > max) {
                result++;
                max = s + m -1;
            } 
        }
        return result;
    }
}