import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int cur = 1;
        int answer = 0;
        while (i < order.length) {
            if (!stack.isEmpty()) {
                if (stack.peek() == order[i]) {
                    stack.pop();
                    i++;
                    answer++;
                    continue;
                }
            }
            if (cur == order[i]) {
                cur++;
                i++;
                answer++;
                continue;
            }
            else {
                if (cur > order.length) {
                    break;
                }
                stack.push(cur);
                cur++;
            }
        }
        return answer;
    }
}