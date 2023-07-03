import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        HashMap<String, Integer> dic = new HashMap<>();
        String[] arr = s.split("");
        for (int i=0; i<arr.length; i++) {
            if (dic.containsKey(arr[i]))
                result[i] = i - dic.get(arr[i]);
            else
                result[i] = -1;
            dic.put(arr[i], i);
        }
        return result;
    }
}