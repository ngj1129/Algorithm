class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if (Character.isWhitespace(arr[i]))
                continue;
            int ascii = (int) arr[i];
            if (ascii >= 65 && ascii <= 90) {
                ascii += n;
                ascii = (ascii-65)%26 + 65;
            }
            else {
                ascii += n;
                ascii = (ascii-97)%26 + 97;
            }
            arr[i] = (char) ascii;
        }
        return String.valueOf(arr);
    }
}