import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" (?=\\S)");
        for (int i=0; i<arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<arr[i].length(); j++) {
                if (j%2 == 0) 
                    sb.append(String.valueOf(arr[i].charAt(j)).toUpperCase());
                else
                    sb.append(String.valueOf(arr[i].charAt(j)).toLowerCase());
            }
            arr[i] = sb.toString();
        }
        return String.join(" ", arr);
    }
}