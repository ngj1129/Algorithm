import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        int ascii = 65;
        for (int i=1; i<27; i++) {
            map.put(String.valueOf(((char) ascii)), i);
            ascii++;
        } 
        int num = 27;
        int w = 0;
        int c = 0;
        String[] arr = msg.split("");
        ArrayList<Integer> list = new ArrayList<>();
        while (w < arr.length) {
            while (c < arr.length) {
                if (!map.containsKey(msg.substring(w, c+1))) {
                    break;
                }
                c++;
            }
            list.add(map.get(msg.substring(w, c)));
            if (c < arr.length-1) {
                map.put(msg.substring(w, c+1), num);
            }
            num++;
            w = c;
            c = w;
        }
        if (w == arr.length-1) {
            list.add(map.get(arr[w]));
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}