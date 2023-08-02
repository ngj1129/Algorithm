import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[][] plans) {
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        Stack<String> stack = new Stack<>();
        String[] result = new String[plans.length];
        
        for (int i=0; i<plans.length; i++) {
            int start = Integer.valueOf(plans[i][1].substring(0, 2))*60 + Integer.valueOf(plans[i][1].substring(3));
            int end = Integer.valueOf(plans[i][2]);
            map1.put(start, plans[i][0]);
            map2.put(plans[i][0], end);
        }
        
        String ing = new String();
        int time = -1;
        int ix = 0;
        int i = -1;
        while (true) {
            i++;
            if (ix==plans.length)
                break;
            if (time==0) {
                result[ix++] = ing;
                ing = new String();
                time = -1;
            }
            if (ing.isEmpty()) {
                if (map1.containsKey(i)) 
                    ing = map1.get(i);
                else if (!stack.isEmpty()) 
                    ing = stack.pop();
                else
                    continue;
                time = map2.get(ing);
                map2.put(ing, --time);
            }
            else {
                if (!map1.containsKey(i)) {
                    map2.put(ing, --time);
                    continue;
                }
                else {
                    stack.push(ing);
                    ing = map1.get(i);
                    time = map2.get(ing);
                    map2.put(ing, --time);
                }
            }
        }
        return result;
    }
}