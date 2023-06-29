class Solution {
    public String solution(int n) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            if (i%2 == 0)
                answer[i] = "수";
            else
                answer[i] = "박";
        }
        return String.join("", answer);
    }
}