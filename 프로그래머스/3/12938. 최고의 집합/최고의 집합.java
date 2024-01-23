class Solution {
    public int[] solution(int n, int s) {
        int quo = s / n;
        int rem = s % n;
        if (quo == 0) {
            return new int[]{-1};
        }
        int[] arr = new int[n];
        for (int i=arr.length-1; i>=0; i--) {
            arr[i] = quo;
            if (rem > 0) {
                arr[i] += 1;
                rem--;
            }
        }
        return arr;
    }
}