import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        if (gems.length == 1) {
            return new int[]{1, 1};
        }
        
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[]{1, gems.length};
        for (int i=0; i<gems.length; i++) {
            if (!map.containsKey(gems[i])) {
                map.put(gems[i], 0);
            }
        }
        
        int kind = map.size();
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < gems.length) {
            int value = map.get(gems[j]);
            if (value == 0) {
                count++;
            }
            map.put(gems[j], ++value);
            j++;
            while (count == kind) {
                if ((j-i-1) < (answer[1] - answer[0])) {
                    answer[0] = i+1;
                    answer[1] = j;
                }
                int firstValue = map.get(gems[i]);
                if (firstValue > 0) {
                    map.put(gems[i], --firstValue);
                    i++;
                    if (firstValue == 0) {
                        count--;
                    }
                }
            }
        }
        // System.out.println(i);
        // System.out.println(j);
        // System.out.println(count);
        // System.out.println(map);
        return answer;
        
    }
}