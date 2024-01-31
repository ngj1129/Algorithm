// import java.util.Arrays;

// class Solution {
//     public int solution(int N, int number) {
//         int[] dp = new int[40001];
//         int num = 0;
//         int count = 1;
//         int[] arr = new int[6];
//         for (int i=0; i<dp.length; i++) {
//             dp[i] = 10000;
//         }
//         for (int i=1; i<=10000; i*=10) {
//             num += N * i;
//             if (num > 40000) {
//                 break;
//             }
//             dp[num] = count;
//             arr[count] = num;
//             count++;
//         }
//         for (int i=1; i<=40000; i++) {
//             if (dp[i] == 10000) {
//                 continue;
//             }
//             for (int j=1; j<6; j++) {
//                 if (arr[j] == 0) {
//                     continue;
//                 }
//                 if (i+arr[j] <= 40000) {
//                     dp[i+arr[j]] = Math.min(dp[i+arr[j]], dp[i]+dp[arr[j]]);
//                 }
//                 if (i-arr[j] > 0) {
//                     dp[i-arr[j]] = Math.min(dp[i-arr[j]], dp[i]+dp[arr[j]]);
//                 }
//                 if (arr[j]-i > 0) {
//                     dp[arr[j]-i] = Math.min(dp[arr[j]-i], dp[i]+dp[arr[j]]);
//                 }
//                 if (i*arr[j] <= 40000) {
//                     dp[i*arr[j]] = Math.min(dp[i*arr[j]], dp[i]+dp[arr[j]]);
//                 }
//                 if (i/arr[j] > 0) {
//                     dp[i/arr[j]] = Math.min(dp[i/arr[j]], dp[i]+dp[arr[j]]);
//                 }
//                 if (arr[j]/i > 0) {
//                     dp[arr[j]/i] = Math.min(dp[arr[j]/i], dp[i]+dp[arr[j]]);
//                 }
//             }
//         }
//         // if (dp[number] > 8) {
//         //     return -1;
//         // }
//         return dp[number];
//     }
//     //88 * {8*8 - (8+8)/8 } - 8
    
// }


import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
class Solution {
    //순서쌍 a에 b 합치기
    public void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for (int n1 : a) {
            for (int n2 : b) {
                union.add(n1 + n2);
                union.add(n1 - n2);
                union.add(n1 * n2);
                if (n2 != 0)
                    union.add(n1 / n2);
            }
        }
    }
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();
        
        for (int i = 0; i < 9; i++)
            setList.add(new HashSet<>()); // 개수 별 해쉬셋
        setList.get(1).add(N); //1개로 만들 수 있는 건 나 자신뿐
        if (number == N)
            return 1;
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i / 2; j++) {
                unionSet(setList.get(i), setList.get(i - j), setList.get(j));
                unionSet(setList.get(i), setList.get(j), setList.get(i - j));
            }
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i))); //연속된 숫자 넣기
            for (int num : setList.get(i))
                if (num == number)
                    return i;
        }
        return -1;
    }
}