import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] intarr = new int[arr.length];
        for (int i=0; i<arr.length; i++) 
            intarr[i] = Integer.valueOf(arr[i]);
        Arrays.sort(intarr);
        return String.valueOf(intarr[0]) + " " + String.valueOf(intarr[intarr.length-1]);
    }
}