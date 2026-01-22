class Solution {
    public int[] solution(int n, int s) {
        int q = s/n;
        int rem = s%n;
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            answer[i] = q;
        }
        for (int i=0; i<rem; i++) {
            answer[n-i-1]++;
        }
        
        if (q == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}