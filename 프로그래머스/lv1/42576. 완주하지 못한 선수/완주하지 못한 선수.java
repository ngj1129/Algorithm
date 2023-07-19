import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String name: completion) {
            if (map.containsKey(name)) {
                int ct = map.get(name);
                map.put(name, ++ct);
            } else {
                map.put(name, 1);
            }
        }
        for (String name: participant) {
            if (!map.containsKey(name))
                return name;
            else if (map.get(name)==0)
                return name;
            else {
                int ct = map.get(name);
                map.put(name, --ct);
            }
        }
        return "";
    }
}