class Solution {
    public int solution(int storey) {
        int count = 0;
        int rem = 0;
        while (storey > 0) {
            rem = storey%10;
            if (rem > 5) {
                count += 10 - rem;
                storey += 10 - rem;
            }
            else if (rem < 5) {
                count += rem;
                storey -= rem;
            }
            else {
                count += 5;
                if ((storey/10)%10 >= 5) {
                    storey += 5;
                }
                else {
                    storey -= 5;
                }
            }
            storey /= 10;
        }
        return count;
    }
}