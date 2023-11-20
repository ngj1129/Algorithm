import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long s1 = QueueSum(queue1);
        long s2 = QueueSum(queue2);
        if ((s1+s2)%2 != 0) {
            return -1;
        }
        Queue<Long> q1 = ArrayToQueue(queue1);
        Queue<Long> q2 = ArrayToQueue(queue2);
        
        boolean check = false;
        int count = 0;
        while (count <= queue1.length * 2 + 2) {
            if (s1 == s2) {
                check = true;
                break;
            }
            else if (s1 > s2) {
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.offer(q1.poll());
            }
            else {
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.offer(q2.poll());
            }
            count++;
        }
        if (check) {
            return count;
        }
        return -1;
    }
    
    public Queue<Long> ArrayToQueue(int[] arr) {
        Queue<Long> q = new LinkedList<Long>();
        for (int num: arr) {
            long n = (long) num;
            q.offer(n);
        }
        return q;
    }
    
    public long QueueSum(int[] arr) {
        long sum = 0;
        for (int num: arr) {
            sum += (long) num;
        }
        return sum;
    }
}