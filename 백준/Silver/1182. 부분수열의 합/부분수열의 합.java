import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int r=1; r<=n; r++) {
            com(n, s, r, arr, 0, 0, 0);
        }
        System.out.println(answer);
    }
    
    public static void com(int n, int s, int r, int[] arr, int sum, int start, int depth) {
        if (depth == r) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        for (int i=start; i<n; i++) { //앞의 숫자를 다시 보지 않으므로(순열이 아니므로) visited가 필요없다.
            com(n, s, r, arr, sum+arr[i], i+1, depth+1);
        }
        return;
    } 
}