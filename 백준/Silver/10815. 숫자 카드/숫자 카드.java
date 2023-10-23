import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[n];
        for (int i=0; i<n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr= new int[m];
        for (int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);
        int i;
        int j;
        int mid;
        boolean flag;
        for (int num: arr) {
            i = 0;
            j = n-1;
            mid = n/2;
            flag = false;
            while (i <= j) {
                if (num == card[mid]) {
                    flag = true;
                    System.out.print(1 + " ");
                    break;
                }  
                else if (num < card[mid]) {
                    j = mid-1;
                    mid = (i+j)/2;
                }
                else {
                    i = mid+1;
                    mid = (i+j)/2;
                }         
            }
            if (!flag) {
                System.out.print(0 + " ");
            }
        }
    }
}