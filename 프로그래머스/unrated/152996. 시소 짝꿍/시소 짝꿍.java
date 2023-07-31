import java.util.HashMap;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        double[] dist = {2, 1.5, 0.75};
        for (int w: weights) {
            if (map.containsKey(w)) {
                long ct = map.get(w);
                map.put(w, ++ct);
            }
            else
                map.put(w, (long)1);
        }
        for (int p1: map.keySet()) {
            long v1 = map.get(p1);
            answer += (v1*(v1-1))/2;
            for (double d: dist) {
                double p = p1 * d;
                if (p%1 != 0)
                    continue;
                int p2 = (int) p;
                if (map.containsKey(p2))
                    answer += v1 * map.get(p2);
            }
        }
        return answer;

    }
}