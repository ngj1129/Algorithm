import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        boolean[] visited = new boolean[N+1];
        perm(N, M, arr, visited, 0);
    }
    
    public static void perm(int n, int m, int[] arr, boolean[] visited, int depth) {
        if (depth == m) {
            for (int num: arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                perm(n, m, arr, visited, depth+1);
                visited[i] = false;
            }
        }
        return;
    } 
}