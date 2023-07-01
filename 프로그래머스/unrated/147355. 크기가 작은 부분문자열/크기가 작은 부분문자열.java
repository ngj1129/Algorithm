class Solution {
    public int solution(String t, String p) {
        int result = 0;
        for (int i=0; i<t.length()-(p.length()-1); i++) {
            long num = Long.valueOf(t.substring(i, i+p.length()));
            long np = Long.valueOf(p);
            if (num <= np)
                result += 1;
        }
        return result;
    }
}