import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n/2;
        if (n%2 != 0) {
            m++;
        }
        int[] arr = new int[n];
        int[][] s = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = i;
            for (int j=0; j<n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] out;
        boolean[] visited;
        for (int r=2; r<=m; r++) {
            out = new int[r];
            visited = new boolean[n];
            com(s, arr, out, visited, 0, 0, r);
        }
        System.out.println(answer);
    }
    public static void com(int[][] s, int[] arr, int[] out, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0; j<arr.length; j++) {
                if (!visited[j]) {
                    list.add(arr[j]);
                }
            }
            int sum1 = 0;
            int sum2 = 0;
            for (int a=0; a<r; a++) {
                for (int b=a+1; b<r; b++) {
                    sum1 += s[out[a]][out[b]];
                    sum1 += s[out[b]][out[a]];
                }
            }
            for (int a=0; a<list.size(); a++) {
                for (int b=a+1; b<list.size(); b++) {
                    sum2 += s[list.get(a)][list.get(b)];
                    sum2 += s[list.get(b)][list.get(a)];
                }
            }
            /*
            System.out.print(sum1);
            System.out.print(" ");
            System.out.println(sum2);
            
            System.out.print(Arrays.toString(out));
            System.out.print("--");
            System.out.println(list);
            */
            if (answer == -1 | Math.abs(sum1-sum2) < answer) {
                answer = Math.abs(sum1-sum2);
            }
            return;
        }
        for (int i=start; i<arr.length; i++) {
            if (!visited[i]) {
                out[depth] = arr[i];
                visited[i] = true;
                com(s, arr, out, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }  
}