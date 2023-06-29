class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a, b;
        if (n < m) {
            a = n;
            b = m;
        }
        else {
            a = m;
            b = n;
        }
        
        
        for (int i=a; i>0; i--) {
            if (a%i == 0 && b%i == 0) {
                answer[0] = i;
                break;
            }
        }
        for (int j=b; j<= m*n; j++) {
            if (j%a == 0 && j%b == 0) {
                answer[1] = j;
                break;
            }
        }
        return answer;
    }
}