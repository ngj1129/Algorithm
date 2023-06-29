class Solution {
    public long solution(long price, long money, long count) {
        long answer = price*count*(count+1)/2;
        if (money >= answer)
            return 0;
        return answer-money;
    }
}