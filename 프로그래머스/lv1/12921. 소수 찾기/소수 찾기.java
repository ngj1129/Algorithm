class Solution {
    public int solution(int n) {
        int result = 0;
        for (int num=2; num<=n; num++) {
            boolean isPrime = true;
            for (int i=2; i<(int) Math.sqrt(num) + 1; i++) {
                if (num>2 && num%i==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                result++;
        }
        return result;
    }
}