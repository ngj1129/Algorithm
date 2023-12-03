class Solution {
    int[] result = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        perm(new int[]{10, 20, 30, 40}, users, emoticons, new int[emoticons.length], 0);
        return result;
    }
    
    public void perm(int[] sale, int[][] users, int[] emoticons, int[] out, int depth) {
        if (depth == emoticons.length) {
            int plus = 0;
            int sum = 0;
            for (int[] user: users) {
                int check = 0;
                for (int i=0; i<emoticons.length; i++) {
                    if (user[0] > out[i]) {
                        continue;
                    }
                    check += (emoticons[i]/100) * (100-out[i]);
                    if (check >= user[1]) {
                        plus++;
                        check = 0;
                        break;
                    }
                }
                sum += check;
            }
            if (plus > result[0]) {
                result[0] = plus;
                result[1] = sum;
            }
            else if (plus == result[0]) {
                if (sum > result[1]) {
                    result[0] = plus;
                    result[1] = sum;
                }
            }
            return;
        }
        for (int i=0; i<sale.length; i++) {
            out[depth] = sale[i];
            perm(sale, users, emoticons, out, depth+1);
        }
    }
}