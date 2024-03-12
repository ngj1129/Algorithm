import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int max = 23*60 + 59;
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String str: records) {
            String car = str.substring(6, 10);
            int time = Integer.valueOf(str.substring(0, 2))*60 + Integer.valueOf(str.substring(3, 5));
            if (!map.containsKey(car)) {
                list = new ArrayList<>();
            }
            else {
                list = map.get(car);
            }
            list.add(time);
            map.put(car, list);
        }
        HashMap<String, Integer> sum = new HashMap<>();
        String[] arr = new String[map.size()];
        int ix = 0;
        for (String key: map.keySet()) {
            int time = 0;
            list = map.get(key);
            for (int i=0; i<list.size()-1; i+=2) {
                time += list.get(i+1) - list.get(i);
            }
            if (list.size()%2 != 0) {
                time += max - list.get(list.size()-1);
            }
            sum.put(key, time);
            arr[ix] = key;
            ix++;
        }
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            int time = sum.get(arr[i]);
            if (time <= fees[0]) {
                result[i] = fees[1];
            }
            else {
                if ((time-fees[0])%fees[2] == 0) {
                    result[i] = fees[1] + ((time-fees[0])/fees[2])*fees[3];
                }
                else {
                    result[i] = fees[1] + (((time-fees[0])/fees[2])+1)*fees[3];
                }
            }
        }
        return result;
    }
}