class Solution {
    public int solution(int number, int limit, int power) {
        int result = 0;
        for (int n=1; n<=number; n++) {
            int ct = 0;
            for (int i=1; i<(int) Math.sqrt(n)+1; i++) {
                if (n%i==0)
                    ct ++;
            }
            if (Math.sqrt(n)%1==0) {
                ct = 2*ct -1;
            } else {
                ct = 2*ct;
            }
            if (ct > limit)
                ct = power;
            result += ct;
        }
        return result;
    }
}