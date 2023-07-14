import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public String solution(String X, String Y) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<X.length(); i++) {
            if (map.containsKey(String.valueOf(X.charAt(i)))) {
                int ct = map.get(String.valueOf(X.charAt(i)));
                map.put(String.valueOf(X.charAt(i)), ++ct);
            } else {
                map.put(String.valueOf(X.charAt(i)), 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Y.length(); i++) {
            if (map.containsKey(String.valueOf(Y.charAt(i)))) {
                int ct = map.get(String.valueOf(Y.charAt(i)));
                if (ct==0)
                    continue;
                sb.append(String.valueOf(Y.charAt(i)));
                map.put(String.valueOf(Y.charAt(i)), --ct);
            }
        }
        if (sb.toString().equals(""))
            return "-1";
        boolean ifzero = true;
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                ifzero = false;
                break;
            }
        }
        if (ifzero==true)
            return "0";
        String[] arr = sb.toString().split("");
        Arrays.sort(arr);
        String str = String.join("", arr);
        StringBuilder result = new StringBuilder(str);
        result = result.reverse();
        return result.toString();
    }
}