import java.util.HashMap;
import java.util.Map;
class Solution {
    public long solution(String s) {
        Map<String, String> dic = new HashMap<>() {{
            put("zero", "0");
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }};
        for (String key: dic.keySet()) {
            String v = dic.get(key);
            if (s.contains(key))
                s = s.replaceAll(key, dic.get(key));
        }
        return Long.valueOf(s);
    }
}