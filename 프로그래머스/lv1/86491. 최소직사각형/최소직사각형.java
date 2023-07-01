class Solution {
    public int solution(int[][] sizes) {
        for (int i=0; i<sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int m1 = 0;
        int m2 = 0;
        for (int i=0; i<sizes.length; i++) {
            if (sizes[i][0] > m1)
                m1 = sizes[i][0];
            if (sizes[i][1] > m2)
                m2 = sizes[i][1];
        }
        return m1*m2;
    }
}