import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean checkRoad(int[] arr, int n, int l) {
        boolean[] check = new boolean[n];
        int i=0;
        while (i < n-1) {
            if (arr[i] == arr[i+1]) {
                i++;
                continue;
            }
            else if (arr[i] - arr[i+1] == 1) { //내려감
                int high = arr[i+1];
                for (int ix=i+1; ix<i+1+l; ix++) {
                    if (ix >= n) {
                        return false;
                    }
                    if (arr[ix] != high | check[ix]) {
                        return false;
                    }
                }
                for (int ix=i+1; ix<i+1+l; ix++) {
                    check[ix] = true;
                }
                i = i+l;
            }
            else if (arr[i+1] - arr[i] == 1) { //올라감
                int high = arr[i];
                for (int ix=i; ix>i-l; ix--) {
                    if (ix < 0) {
                        return false;
                    }
                    if (arr[ix] != high | check[ix]) {
                        return false;
                    }
                }
                for (int ix=i; ix>i-l; ix--) {
                    check[ix] = true;
                }
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int answer = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            if (checkRoad(map[i], n, l)) {
                answer++;
            }
        }
        for (int i=0; i<n; i++) {
            int[] tmp = new int[n];
            for (int j=0; j<n; j++) {
                tmp[j] = map[j][i];
            }
            if (checkRoad(tmp, n, l)) {
                answer++;
            }
        } 
        System.out.println(answer);
    } 
}