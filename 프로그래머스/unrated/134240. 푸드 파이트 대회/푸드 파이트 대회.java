class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            int div = food[i]/2;
            for (int j=0; j<div; j++)
                sb.append(i);
        }
        StringBuilder re = new StringBuilder(sb).reverse();
        sb.append("0");
        sb.append(re);
        return sb.toString();
    }
}