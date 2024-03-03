import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i=0; i<book_time.length; i++) {
            String[] arr = book_time[i];
            time[i][0] = Integer.valueOf(arr[0].substring(0, 2)) * 60 + Integer.valueOf(arr[0].substring(3, 5));
            time[i][1] = Integer.valueOf(arr[1].substring(0, 2)) * 60 + Integer.valueOf(arr[1].substring(3, 5)) + 10;
        }
        Arrays.sort(time, Comparator.comparingInt(arr -> arr[0]));
        for (int i=0; i<time.length; i++) {
            int start = time[i][0];
            int end = time[i][1];
            if (!pq.isEmpty()) {
                if (start >= pq.peek()) {
                    pq.poll();
                    pq.offer(end);
                    continue;
                }
            }
            answer++;
            pq.offer(end);
        }
        return answer;
    }
}