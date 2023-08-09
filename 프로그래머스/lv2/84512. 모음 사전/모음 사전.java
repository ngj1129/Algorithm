class Solution {
    public int count;
    public boolean check;
    public int result;
    public int solution(String word) {
        String[] alpha = {"A", "E", "I", "O", "U"};
        String[] out = new String[5];
        count = 0;
        result = 0;
        perm(word, alpha, out, 0);
        return result;
    }
    
    public void perm(String word, String[] alpha, String[] out, int depth) {
        if (check)
            return;
        if (depth == 5) {
            return;
        }
        for (int i=0; i<5; i++) {
            out[depth] = alpha[i];
            count++;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<=depth; j++) {
                sb.append(out[j]);
            }
            String w = sb.toString();
           
            if (w.equals(word)) {
                check = true;
                result = count;
            }
            perm(word, alpha, out, depth+1);
        }
    }
}