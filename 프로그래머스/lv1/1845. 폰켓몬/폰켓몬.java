import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length/2;
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(arr);
        HashSet<Integer> set = new HashSet<>(list);
        if (set.size() < n)
            return set.size();
        return n;
    }
}