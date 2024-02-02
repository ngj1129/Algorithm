import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(String name) {
        String reverse = "";        
        for (int i = name.length() - 1; i >= 0; i--) {            
            reverse = reverse + name.charAt(i);        
        }
        return Math.min(joy(name), joy(reverse)+1);
    }
    public int joy(String name) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<name.length(); i++) {
            if (name.charAt(i) != 'A') {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        int n = name.length();
        int end = list.get(list.size()-1);
        int count = n+1;
        if (list.size() == 1) {
            count = Math.min(end, n-end);
        }
        for (int i=0; i<list.size()-1; i++) {
            int x = list.get(i);
            int y = list.get(i+1);
            int tmp = Math.min(end, (2*x)+(n-y));
            if (tmp < count) {
                count = tmp;
            }
        }
        for (int i=0; i<name.length(); i++) {
            if (name.charAt(i) == 'A') {
                continue;
            }
            int num = (int) name.charAt(i);
            count += Math.min((num-65), (90+1-num));
        }
        return count;
    }
}