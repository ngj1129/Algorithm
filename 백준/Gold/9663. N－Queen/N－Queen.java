import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        nqueen(n, arr, 0);
        System.out.println(answer);
    }
    
    public static void nqueen(int n, int[][] arr, int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        int x;
        int y;
        for (int i=0; i<n; i++) {
            if (arr[depth][i] == 0) {
                arr[depth][i] = depth+1;
                for (int r=0; r<n; r++) {
                    if (arr[depth][r] == 0) {
                        arr[depth][r] = depth+1;
                    }
                }
                
                for (int c=0; c<n; c++) {
                    if (arr[c][i] == 0) {
                        arr[c][i] = depth+1;
                    }
                }
                x = depth-1;
                y = i+1;
                while (x >= 0 && y < n) {
                    if (arr[x][y] == 0) {
                        arr[x][y] = depth+1;
                    } 
                    x--;
                    y++;
                }
                x = depth+1;
                y = i-1;
                while (x < n && y >= 0) {
                    if (arr[x][y] == 0) {
                        arr[x][y] = depth+1;
                    }
                    x++;
                    y--;
                }
                x = depth+1;
                y = i+1;
                while (x < n && y < n) {
                    if (arr[x][y] == 0) {
                        arr[x][y] = depth+1;
                    }
                    x++;
                    y++;
                }
                x = depth-1;
                y = i-1;
                while (x >= 0 && y >= 0) {
                    if (arr[x][y] == 0) {
                        arr[x][y] = depth+1;
                    }
                    x--;
                    y--;
                }
                nqueen(n, arr, depth+1);
                arr[depth][i] = 0;
                for (int a=0; a<n; a++) {
                    for (int b=0; b<n; b++) {
                        if (arr[a][b] == depth+1) {
                            arr[a][b] = 0;
                        }
                    }
                }
            }
        }
        return;
    } 
}