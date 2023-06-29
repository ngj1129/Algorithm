import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(String s) {
        int[] ascii = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            char alpha = s.charAt(i);
            int num = (int) alpha;
            ascii[i] = num;
        }
        Integer[] intg = Arrays.stream(ascii).boxed().toArray(Integer[]::new);
        Arrays.sort(intg, Comparator.reverseOrder());
        int[] intArray = Arrays.stream(intg).mapToInt(Integer::intValue).toArray();
        
        String[] answer = new String[s.length()];
        for (int i=0; i<s.length(); i++)
            answer[i] = Character.toString((char) intArray[i]);
        return String.join("", answer);
    }
}