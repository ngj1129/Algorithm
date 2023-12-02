import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<works.length; i++) {
            pq.offer(works[i]);
        }
        for (int i=0; i<n; i++) {
            int work = pq.poll();
            if (work == 0) {
                break;
            }
            pq.offer(--work);
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            if (work == 0) {
                continue;
            }
            answer += (long) Math.pow(work, 2);
        }
        return answer;
    }
}