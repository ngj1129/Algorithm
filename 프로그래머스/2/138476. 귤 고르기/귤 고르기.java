import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int tan:tangerine) {
            if (map.containsKey(tan)) {
                int c = map.get(tan);
                map.put(tan, ++c);
            }
            else {
                map.put(tan, 1);
            }
        }
        int[][] arr = new int[map.size()][2];
        int ix = 0;
        for (int tan: map.keySet()) {
            arr[ix][0] = tan;
            arr[ix][1] = map.get(tan);
            ix++;
        }
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]).reversed());
        int answer = 0;
        for (int i=0; i<arr.length; i++) {
            if (k <= 0) {
                break;
            }
            k -= arr[i][1];
            answer++;
        }
        return answer;
    }
}