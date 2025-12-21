import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());//내림차순 정렬
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();//오름차순정렬
        
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
           //큐가 비어있을 때는 패스
            if(s[0].equals("D") && maxQueue.isEmpty()) {
                continue;
            }
            //큐에 삽입
            if(s[0].equals("I")) {
                maxQueue.offer(Integer.parseInt(s[1]));
                minQueue.offer(Integer.parseInt(s[1]));
            }
            else if(s[0].equals("D") && s[1].equals("1")) {
                int max = maxQueue.poll();
                minQueue.remove(max);
            } else {
                int min = minQueue.poll();
                maxQueue.remove(min);
            }
        }

        if(maxQueue.isEmpty()) return new int[] {0,0};
        else return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}

// class Solution {
//     public static class com implements Comparator<Integer> {
// 		@Override
// 		public int compare(Integer n1, Integer n2) {
// 			return Integer.compare(n2, n1);
// 		}
// 	}
    
//     public int[] solution(String[] operations) {
//         PriorityQueue<Integer> ascQ = new PriorityQueue<>();
//         PriorityQueue<Integer> descQ = new PriorityQueue<>(new com());
//         int size = 0;
//         for (String str: operations) {
//             String[] strArr = str.split(" ");
//             int num = Integer.parseInt(strArr[1]);
//             if (strArr[0].equals("I")) {
//                 ascQ.offer(num);
//                 descQ.offer(num);
//                 size++;
//             }
//             else {
//                 if (size == 0) {
//                     continue;
//                 }
//                 if (num == 1) {
//                     descQ.poll();
//                 }
//                 else {
//                     ascQ.poll();
//                 }
//                 size--;
//                 if (size == 0) {
//                     descQ.clear();
//                     ascQ.clear();
//                 }
//             }
//         }
//         if (size == 0) {
//             return new int[]{0, 0};
//         }
//         return new int[]{descQ.poll(), ascQ.poll()};
//     }
// }