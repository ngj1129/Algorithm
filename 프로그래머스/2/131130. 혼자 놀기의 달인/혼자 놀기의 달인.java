import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int count = 0;
        int check = 0;
        while (check < cards.length) {
            if (!visited[i]) {
                visited[i] = true;
                //System.out.println(i+1);
                i = cards[i] - 1;
                count++;
                check++;
            }
            else {
                if (count > 0) {
                    list.add(count);
                    //System.out.println(count);
                    count = 0;
                    i = 0;
                }
                else {
                    i++;
                }
            }
        }
        if (count > 0) {
            list.add(count);
        }
        int[] arr = new int[list.size()];
        for (int ix=0; ix<arr.length; ix++) {
            arr[ix] = list.get(ix);
        }
        Arrays.sort(arr);
        if (arr.length < 2) {
            return 0;
        }
        return arr[arr.length-1] * arr[arr.length-2];
    }
}