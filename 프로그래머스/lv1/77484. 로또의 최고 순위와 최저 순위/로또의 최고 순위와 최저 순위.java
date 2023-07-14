class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int unknown = 0;
        int equal = 0;
        for (int lo: lottos) {
            for (int win: win_nums) {
                if (lo == win) {
                    equal++;
                    break;
                }
                else if (lo == 0) {
                    unknown++;
                    break;
                }
            }
        }
        int good = 7 - equal - unknown;
        int bad = 7 - equal;
        if (good==7)
            good = 6;
        if (bad==7)
            bad = 6;
        return new int[]{good, bad};
    }
}