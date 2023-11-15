import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);    
        int a = arrayA[0];
        for (int i=1; i<arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }
        int b = arrayB[0];
        for (int i=1; i<arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }
        boolean check = false;
        for (int num: arrayB) {
            if (num%a == 0) {
                check = true;
                break;
            }
        }
        if (check) {
            a = 0;
        }
        check = false;
        for (int num: arrayA) {
            if (num%b == 0) {
                check = true;
                break;
            }
        }
        if (check) {
            b = 0;
        }
        return Math.max(a, b);
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}