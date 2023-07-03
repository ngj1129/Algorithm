import java.util.HashMap;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> dic = new HashMap<>();
        int[] result = new int[photo.length];
        for (int i=0; i<name.length; i++)
            dic.put(name[i], yearning[i]);
        for (int i=0; i<photo.length; i++) {
            for(String per: photo[i]) {
                if (dic.containsKey(per))
                    result[i] += dic.get(per);
            }
        }
        return result;
    }
}