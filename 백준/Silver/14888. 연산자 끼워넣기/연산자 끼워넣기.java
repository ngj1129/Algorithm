import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = 1000000000;
    static int max = -1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] op = new int[n-1];
        boolean[] visited = new boolean[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i=0; i<4; i++) {
            int ct = Integer.parseInt(st.nextToken());
            for (int j=0; j<ct; j++) {
                if (i == 0) {
                    op[idx] = 1;
                    idx++;
                }
                else if (i == 1) {
                    op[idx] = 2;
                    idx++;
                }
                else if (i == 2) {
                    op[idx] = 3;
                    idx++;
                }
                else {
                    op[idx] = 4;
                    idx++;
                }
            }
        }
        operation(arr, op, visited, 0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    public static void operation(int[] arr, int[] op, boolean[] visited, int depth, int tmp) {
        if (depth == op.length) {
            if (tmp < min) {
                min = tmp;
            }
            if (tmp > max) {
                max = tmp;
            }
            return;
        }
        for (int i=0; i<op.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if (op[i] == 1) {
                    operation(arr, op, visited, depth+1, tmp+arr[depth+1]);
                }
                else if (op[i] == 2) {
                    operation(arr, op, visited, depth+1, tmp-arr[depth+1]);
                }
                else if (op[i] == 3) {
                    operation(arr, op, visited, depth+1, tmp*arr[depth+1]);
                }
                else {
                    operation(arr, op, visited, depth+1, tmp/arr[depth+1]);
                }
                visited[i] = false;
            }
        }
    }    
}