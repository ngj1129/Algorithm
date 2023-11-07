import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int num = 2; num <= N; num++) {
            boolean flag = false;
            for (int i = 2; i <= (int) Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(num);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        int answer = 0;
        if (arr.length > 0) {
            if (arr[arr.length-1] == N) {
                answer++;
            }
            int i = 0;
            int j = i+1;
            int sum = arr[i];
            while (j < arr.length && i < arr.length) {
                if (sum == N) {
                    answer++;
                    sum -= arr[i];
                    sum += arr[j];
                    i++;
                    j++;
                } else if (sum < N) {
                    sum += arr[j];
                    j++;
                } else {
                    sum -= arr[i];
                    i++;
                }
            }
        }
        System.out.println(answer);
    }
}