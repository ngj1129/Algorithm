class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long deli = 0;
        long pick = 0;
        for (int d: deliveries) {
            deli += (long) d;
        }
        for (int p: pickups) {
            pick += (long) p;
        }
        int i = n-1;
        int j = n-1;
        while (deli > 0 | pick > 0) {
            int count = 0;
            int di = -1;
            while (count < cap) {
                if (deli == 0) {
                    break;
                }
                if (deliveries[i] > 0) {
                    if (di == -1) {
                        di = i;
                    }
                    int check = cap-count;
                    if (deliveries[i] >= check) {
                        deliveries[i] -= check;
                        count += check;
                        deli -= check;
                        break;
                    }
                    else {
                        count += deliveries[i];
                        deli -= deliveries[i];
                        deliveries[i] = 0;
                        i--;
                    }
                }
                else {
                    i--;
                }
            } 
            count = 0;
            int pi = -1;
            while (count < cap) {
                if (pick == 0) {
                    break;
                }
                if (pickups[j] > 0) {
                    if (pi == -1) {
                        pi = j;
                    }
                    int check = cap-count;
                    if (pickups[j] >= check) {
                        pickups[j] -= check;
                        count += check;
                        pick -= check;
                        break;
                    }
                    else {
                        count += pickups[j];
                        pick -= pickups[j];
                        pickups[j] = 0;
                        j--;
                    }
                }
                else {
                    j--;
                }
            }
            answer += (long) Math.max(di+1, pi+1) * 2;
            i = di;
            j = pi;
        }
        return answer;
    }
}