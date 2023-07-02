import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, Comparator.comparing(s -> s.charAt(n)));
        return strings;
    }
}