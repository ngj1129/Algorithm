import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int num: arr) {
            if (num < 0) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        int[] a = new int[list1.size()];
        int[] b = new int[list2.size()];
        for (int i=0; i<list1.size(); i++) {
            a[i] = -1 * list1.get(list1.size()-i-1);
        }
        
        for (int i=0; i<list2.size(); i++) {
            b[i] = list2.get(i);
        }
        
        if (a.length == 0) {
            System.out.println(book(b, m));
            return;
        }
        else if (b.length == 0) {
            System.out.println(book(a, m));
            return;
        }
        if (a[a.length-1] < b[b.length-1]) { //a먼저 수행
            System.out.println(book(a, m) + a[a.length-1] + book(b, m));
            return;
        }
        else {
            System.out.println(book(b, m) + b[b.length-1] + book(a, m));
            return;
        }
    }

    public static int book(int[] arr, int m) {
        int answer = 0;
        int temp = 0;
        int fin = arr.length;
        for (int i: arr) {
            if (fin%m == 0) {
                answer += ((fin/m)*2)*(i-temp) - (i-temp);
            }
            else {
                answer += ((fin/m+1)*2)*(i-temp) - (i-temp);
            }
            fin--;
            temp = i; 
        }
        return answer;

    }
}