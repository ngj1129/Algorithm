class Solution {
    public static int answer;
    public static int call=0;
    public static int[] nums;
    public static void getAnswer(int index,int sum,int count){
        if(count==3){
            call++;
            if(sum==0){
                answer++;
            }
        }else if(index<nums.length){
            getAnswer(index+1,sum+nums[index],count+1);
            getAnswer(index+1,sum,count);
        }
    }

    public int solution(int[] number) {
        answer = 0;
        nums=new int[number.length];
        for(int i=0;i<number.length;i++){
            nums[i]=number[i];
        }
        getAnswer(0,0,0);
        return answer;
    }
}
/*
class Solution {
    public int solution(int[] number) {
        int result = 0;
        for (int i=0; i<number.length; i++) {
            for (int j=i+1; j<number.length; j++) {
                for (int k=j+1; k<number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0)
                        result++;
                }
            }
        }
        return result;
    }
}
*/