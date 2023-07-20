class Solution {
    public int solution(String s) {
        char m = '\n';
        int me = 0;
        int others = 0;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (me == 0) {
                m = s.charAt(i);
                me++;
                continue;
            }
            if (m == s.charAt(i))
                me++;
            else
                others++;
            if (me == others) {
                result++;
                me = 0;
                others = 0;
                m = '\n';
            }
        }
        if (m != '\n') 
            result++;
        return result;
    }
}