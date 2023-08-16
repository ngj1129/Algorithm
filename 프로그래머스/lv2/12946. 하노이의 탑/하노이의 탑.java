import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();

    public void hanoi(int n, int start, int end, int sub) {
        if (n==1) {
            list.add(new int[]{start, end});
            return;
        }
        hanoi(n-1, start, sub, end);
        list.add(new int[]{start, end});
        hanoi(n-1, sub, end, start);
    }
    public int[][] solution(int n) {
        int len = (int) Math.pow(2, n) - 1;
        int[][] answer = new int[len][2];
        hanoi(n, 1, 3, 2);
        for (int i=0; i<list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
}