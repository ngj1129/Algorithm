import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int min = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (findRock(distance, rocks, n, mid) <= n) {
                min = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return min;
    }
    public int findRock(int distance, int[] rocks, int n, int mid) {
        int before = 0; 
        int end = distance;
        
        int removeCnt = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - before < mid) {
                removeCnt++;
                continue;
            }
            before = rocks[i];
        }
        if(end - before < mid) removeCnt++;

        return removeCnt;
        // int check = 0;
        // long gap = (long) rocks[0];
        // for (int i=1; i<rocks.length-1; i++) {
        //     if (gap < mid) {
        //         check++;
        //         gap += (long) rocks[i+1] - (long) rocks[i];
        //     }
        //     else {
        //         gap = (long) rocks[i+1] - (long) rocks[i];
        //     }
        // }
        // if (gap < mid) {
        //     check++;
        //     gap += (long) distance - (long) rocks[rocks.length-1];
        // }
        // else {
        //     gap = (long) distance - (long) rocks[rocks.length-1];
        // }
        // if (gap < mid) {
        //     check++;
        // }
        // return check;
    }
}