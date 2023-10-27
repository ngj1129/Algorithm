import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] city = new int[n];
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        long m = Long.parseLong(br.readLine());
        Arrays.sort(city);
        int i = 1;
        int j = city[city.length - 1];
        int mid = (i + j) / 2;
        int budget = 0;
        long sum = 0;
        long diff = m;
        while (i <= j) {
            sum = 0;
            //System.out.print(mid +" ");
            for (int req : city) {
                if (req > mid) {
                    sum += (long) mid;
                } else {
                    sum += (long) req;
                }
            }
            //System.out.println(sum);
            if (sum == m) {
                diff = 0;
                budget = mid;
                break;
            }
            else if (sum > m) {
                j = mid - 1;
                mid = (i+j)/2;
            } 
            else {
                if ((m-sum) < diff) {
                    diff = m-sum;
                    budget = mid;
                }
                i = mid + 1;
                mid = (i + j) / 2;
            } 
        }
        System.out.println(budget);
    }
}