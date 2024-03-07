import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Solution {
    public int solution(int[] stones, int k) {
        int result = 0;
        int max = 0;
        int min = 0;
        //int min = 200000001;
        for (int i=0; i<stones.length; i++) {
            if (stones[i] > max) {
                max = stones[i];
            }
            // if (stones[i] < min) {
            //     min = stones[i];
            // }
        }
        int mid = 0;
        int[] arr = new int[stones.length];
        while (min <= max) {
            mid = (max + min) / 2;
            for (int i=0; i<arr.length; i++) {
                arr[i] = stones[i]-mid;
            }
            boolean check = false;
            int zero = 0;
            for (int i=0; i<arr.length; i++) {
                if (arr[i] <= 0) {
                    zero++;
                    if (zero == k) { //못건너면
                        check = true;
                        break;
                    }
                }
                else {
                    zero = 0;
                }
            }
            if (check) {
                // if (mid < result) {
                //     result = mid;
                // }
                max = mid-1;
            }
            else {
                if (mid+1 > result) {
                    result = mid+1;
                }
                min = mid+1;
            }
        }
        return result; 
    }
}