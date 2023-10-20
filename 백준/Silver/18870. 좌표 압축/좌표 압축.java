import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        int[] s_arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s_arr[i] = arr[i];
        }
        Arrays.sort(s_arr);
        int i = 0;
        int j = 1;
        int ix = 0;
        while (j < n) {
            if (s_arr[i] == s_arr[j]) {
                j++;
            }
            else {
                map.put(s_arr[i], ix);
                i = j;
                j = i+1;
                ix++;
            }
        }
        map.put(s_arr[i], ix);
        StringBuilder sb = new StringBuilder();
        for (int num: arr) {
            sb.append(map.get(num) + " ");
        }
        System.out.println(sb.toString());
    }
}