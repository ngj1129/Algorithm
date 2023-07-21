class Solution {
    public int[] solution(String s) {
        int ct = 0;
        int delzero = 0;
        int len = 0;
        while (s.length() > 1) {
            len = s.length();
            s = s.replace("0", "");
            delzero += len - s.length();
            s = Integer.toBinaryString(s.length());
            ct++;
        }
        return new int[]{ct, delzero};
    }
}