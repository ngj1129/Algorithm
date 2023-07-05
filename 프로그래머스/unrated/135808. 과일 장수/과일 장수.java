import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int k, int m, int[] score) {
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.reverseOrder());
        int result = 0;
        for (int i=m-1; i<score.length; i+=m)
            result += arr[i] * m;
        return result;
    }
}