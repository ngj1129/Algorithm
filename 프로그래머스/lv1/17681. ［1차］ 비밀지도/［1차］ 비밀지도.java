class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            String orbin = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (orbin.length() < n)
                orbin = "0" + orbin;
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (orbin.charAt(j) == '1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}