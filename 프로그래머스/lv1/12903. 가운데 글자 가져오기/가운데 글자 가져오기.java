class Solution {
    public String solution(String s) {
        int m = s.length()/2;
        if (s.length()%2 == 0)
            return s.substring(m-1, m+1);
        else
            return s.substring(m, m+1);
    }
}