class Solution {
    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        double[] fails = new double[N];
        for (int stage=1; stage<=N; stage++) {
            int tried = 0;
            int notyet = 0;
            double fail = 0;
            for (int i=0; i<stages.length; i++) {
                if (stages[i] >= stage) 
                    tried++;
                if (stages[i] == stage)
                    notyet++;
            }
            if (tried > 0)
                fail = (double) notyet/tried;
            fails[stage-1] = fail;
        }
        for (int i=0; i<N; i++) {
            double max = fails[0];
            int im = 0;
            for (int j=1; j<N; j++) {
                if (fails[j] > max) {
                    max = fails[j];
                    im = j;
                }
            }
            result[i] = im+1;
            fails[im] = -1;
        }
        return result;
    }
}