import java.util.ArrayList;
class Solution {
    public int solution(int[] nums) {
        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> sums = new ArrayList<>();
        combinations(nums, three, 0, 3, sums);
        int result = 0;
        for (int num: sums) {
            boolean isPrime = true;
            for (int i=2; i<num; i++) {
                if (num%i==0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                result++;
        }
        return result;
    }
    
    public void combinations(int[] num, ArrayList<Integer> three, int ix, int r, ArrayList<Integer> sums) {
        if (r==0) {
            int sum = 0;
            for (int i=0; i<3; i++)
                sum += three.get(i);
            sums.add(sum);
        } else {
            for (int i=ix; i<num.length; i++) {
                three.add(num[i]);
                combinations(num, three, i+1, r-1, sums);
                three.remove(Integer.valueOf(num[i]));
            }
        }
        
    }
}