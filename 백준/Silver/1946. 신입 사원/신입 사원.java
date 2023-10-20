import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int lastElement1 = o1[0];
                    int lastElement2 = o2[0];
                    return Integer.compare(lastElement1, lastElement2);
                }
            });
            int min = n+1;
            for (int i=0; i<n; i++) {
                if (arr[i][1] < min) {
                    answer++;
                    min = arr[i][1];
                }
            }
            System.out.println(answer);
        }
    }      
}