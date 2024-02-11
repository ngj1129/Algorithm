class Solution {
    public int solution(String s) {
        int answer = 1;
        String[] arr = s.split("");
        for (int i=0; i<arr.length; i++) {
            int ix = i;
            int left = i-1;
            int right = i+1;
            int c1 = 1;
            int c2 = 0;
            while (left >= 0 && right < arr.length) {
                if (arr[left].equals(arr[right])) {
                    c1 += 2;
                    left--;
                    right++;
                }
                else {
                    break;
                }
            }
            right = i+1;
            while (ix >= 0 && right < arr.length) {
                if (arr[ix].equals(arr[right])) {
                    c2 += 2;
                    ix--;
                    right++;
                }
                else {
                    break;
                }
            }
            if (c1 > answer) {
                answer = c1;
            }
            if (c2 > answer) {
                answer = c2;
            }
        }
        return answer;
    }
}