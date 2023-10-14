import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] rec = new boolean[9][9];

        ArrayList<int[]> hlist = new ArrayList<>();
        int hole = 0;
        int num;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    hole++;
                    hlist.add(new int[]{i, j});
                }
                else {
                    row[i][num-1] = true;
                    col[j][num-1] = true;
                    rec[(i/3)*3+j/3][num-1] = true;
                }
                map[i][j] = num;
            }
        }
        int[][] holes = new int[hole][2];
        for (int i=0; i<hole; i++) {
            holes[i][0] = hlist.get(i)[0];
            holes[i][1] = hlist.get(i)[1];
        }
        dfs(map, row, col, rec, hole, 0, holes);
    }

    public static void dfs(int[][] map, boolean[][] row, boolean[][] col, boolean[][] rec, int hole, int i, int[][] holes) {
        if (flag) {
            return;
        }
        if (hole == 0) {
            flag = true;
            for (int ix = 0; ix < 9; ix++) {
                for (int j=0; j < 9; j++) {
                    System.out.print(map[ix][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        int hx;
        int hy;
        hx = holes[i][0];
        hy = holes[i][1];
        boolean check = false;
        for (int n=1; n<=9; n++) {
            if (!row[hx][n-1] && !col[hy][n-1] && !rec[(hx/3)*3+hy/3][n-1]) {
                check = true;
                map[hx][hy] = n;
                row[hx][n-1] = true;
                col[hy][n-1] = true;
                rec[(hx/3)*3+hy/3][n-1] = true;

                dfs(map, row, col, rec, hole-1, i+1, holes);

                row[hx][n-1] = false;
                col[hy][n-1] = false;
                rec[(hx/3)*3+hy/3][n-1] = false;
            }
        }
    
        if (!check) {
            return;
        }
       
        return;
    }
}