class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean fir = true;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                fir = true;
                sb.append(" ");
            } else if (fir == true) {
                fir = false;
                if (Character.isLetter(s.charAt(i))) 
                    sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                else
                    sb.append(String.valueOf(s.charAt(i)));
            } else {
                if (Character.isLetter(s.charAt(i))) 
                    sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                else
                    sb.append(String.valueOf(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}