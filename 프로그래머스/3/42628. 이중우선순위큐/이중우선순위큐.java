import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        for (String str: operations) {
            String[] arr = str.split(" ");
            String op = arr[0];
            int num = Integer.valueOf(arr[1]);
            if (op.equals("I")) {
                minq.offer(num);
                maxq.offer(num);
            }
            else if (op.equals("D")) {
                if (num == 1) {
                    if (!maxq.isEmpty()) {
                        int pop = maxq.poll();
                        minq.remove(pop);
                    }
                }
                else {
                    if (!minq.isEmpty()) {
                        int pop = minq.poll();
                        maxq.remove(pop);
                    }
                }
            }
        }
        if (maxq.isEmpty()) {
            return new int[] {0, 0};
        }
        return new int[]{maxq.peek(), minq.peek()};
    }
}