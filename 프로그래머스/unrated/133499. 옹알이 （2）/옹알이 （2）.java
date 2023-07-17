import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String[] babbling) {
        int result = 0;
        ArrayList<String> list = new ArrayList<>(List.of("aya", "ye", "woo", "ma"));
        for (int i=0; i<babbling.length; i++) {
            boolean check = true;
            StringBuilder cur = new StringBuilder();
            String pre = new String();
            for (int j=0; j<babbling[i].length(); j++) {
                cur.append(String.valueOf(babbling[i].charAt(j)));
                System.out.println(cur);
                if (list.contains(cur.toString())) {
                    if (cur.toString().equals(pre)) {
                        cur = new StringBuilder();
                        pre = "";
                        check = false;
                        break;
                    } else {
                        pre = new String(cur.toString());
                        cur = new StringBuilder();
                    }
                }
            }
            if (check==true && cur.length()==0) {
                result++;
            }
            
        }
        return result;
        
    }
}