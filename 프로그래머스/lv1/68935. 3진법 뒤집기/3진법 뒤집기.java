class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(String.valueOf(n%3));
            n /= 3;
        }
        sb.reverse();
        int answer = 0;
        for (int i=0; i<sb.length(); i++)
            answer += (int) Math.pow(3, i) * Integer.valueOf(String.valueOf(sb.charAt(i)));
        return answer;
    }
}