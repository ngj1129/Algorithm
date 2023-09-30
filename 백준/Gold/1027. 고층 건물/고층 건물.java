import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1; i<=n; i++) {
            int tmp = 0;
            int a = arr[i];
            int b;
            boolean flag;
            for (int j=1; j<i; j++) {
                if (j == i-1) {
                    tmp++;
                    continue;
                }
                b = arr[j];
                flag = false;
                for (int k=j+1; k<i; k++) {
                    if ((long)(i-j) * arr[k] >= (long)(a-b)*k + (long)(i-j)*a - (long)(a-b)*i) {
                        flag = true;
                        break;
                    } 
                }
                if (!flag) {
                    tmp++;
                }
            }
            for (int j=i+1; j<=n; j++) {
                if (j == i+1) {
                    tmp++;
                    continue;
                }
                b = arr[j];
                flag = false;
                for (int k=i+1; k<j; k++) {
                    if ((long)(i-j) * arr[k] <= (long)(a-b)*k + (long)(i-j)*a - (long)(a-b)*i) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    tmp++;
                }
            }
            if (tmp > answer) {
                answer = tmp;
            }
        }
        System.out.println(answer);
    }
}