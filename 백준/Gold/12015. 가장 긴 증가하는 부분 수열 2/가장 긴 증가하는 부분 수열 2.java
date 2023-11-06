import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = arr[0];
        int a = 1;
        for (int ix=1; ix<N; ix++) {
            if (arr[ix] > lis[a-1]) {
                a++;
                lis[a-1] = arr[ix];
            }
            else {
                int i = 0;
                int j = a;
                int mid = (i+j)/2;
                while (i < j) {
                    if (arr[ix] > lis[mid]) {
                        i = mid + 1;
                        mid = (i+j)/2;
                    }
                    else {
                        j = mid;
                        mid = (i+j)/2;
                    }
                }
                lis[i] = arr[ix];
            }
        }
        System.out.println(a);
    }
}