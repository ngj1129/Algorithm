import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max;
        int ix;
        int im;
        int ct;
        long answer;
        for (int i=0; i<t; i++) {
            int d = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[d];
            int[] marr = new int[d];
            for (int j=0; j<d; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                marr[j] = arr[j];
            }
            Arrays.sort(marr);

            ix = 0;
            im = marr.length-1;
            max = marr[im];
            ct = 0;
            answer = 0;
            int[] check = new int[max+1];
            for (int k=0; k<d; k++) {
                check[arr[k]]++;
            }
            while (ix < arr.length) {
                check[arr[ix]]--;
                if (arr[ix] == max) {
                    answer += (long) ct * max;
                    while (true) { 
                        im--;
                        if (im < 0) {
                            break;
                        }
                        if (check[marr[im]] != 0) {
                            break;
                        }
                    }
                    if (im < 0) {
                        break;
                    }
                    max = marr[im];
                    ct = 0;
                }   
                else {
                    ct++;
                    answer -= (long) arr[ix];
                }
                ix++;
            }
            System.out.println(answer);    
        }
    }
}