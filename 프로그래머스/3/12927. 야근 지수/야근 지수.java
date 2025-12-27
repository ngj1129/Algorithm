import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<works.length; i++) {
            queue.offer(works[i]);
        }
        while (n > 0 && !queue.isEmpty()) {
            int work = queue.poll();
            work--;
            if (work > 0) {
                queue.offer(work);
            }
            n--;
        }
        long result = 0;
        while (!queue.isEmpty()) {
            int work = queue.poll();
            result += (work * work);
        }
        return result;
    }
}