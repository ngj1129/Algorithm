import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int score = 0;
        int curIx = 0;
        for (int i=0; i<A.length; i++) {
            int numA = A[i];
            while (curIx < A.length) {
                if (B[curIx] > A[i]) {
                    score++;
                    curIx++;
                    break;
                }
                curIx++;
            }
        }
        return score;
    }
}