import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num: arr) {
            int l = list.size();
            if (l > 0) {
                if (num == list.get(l-1))
                    continue;
            }
            list.add(num);
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}