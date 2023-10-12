import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static String vow = "aeiou";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] arr = new String[c];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<c; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        com(l, c, arr, new String[l], new boolean[c], 0, 0);
    }
    
    public static void com(int l, int c, String[] arr, String[] out, boolean[] visited, int start, int depth) {
        if (depth == l) {
            int onevow = 0;
            int twocon = 0;
            for (String s: out) {
                if (vow.contains(s)) {
                    onevow++;
                }
                else {
                    twocon++;
                }
            }
            if (onevow >= 1 && twocon >= 2) {
                for (String s: out) {
                    System.out.print(s);
                }
                System.out.println();
            }
            return;
        }
        for (int i=start; i<c; i++) {
            if (!visited[i]) {
                out[depth] = arr[i];
                visited[i] = true;
                com(l, c, arr, out, visited, i+1, depth+1);
                visited[i] = false;
            }
        }
        return;
    } 
}