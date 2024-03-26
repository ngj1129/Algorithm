import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int command = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dir = {{0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; //동서남북
        int[] dice = {0, 0, 0, 0, 0, 0, 0}; //주사위 면 숫자
        int[] updown = {1, 5, 6, 2};
        int[] leri = {1, 3, 6, 4};
        int head = 1;
        int tail = 6;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            //System.out.println(Arrays.toString(map[i]));
        }
        st = new StringTokenizer(br.readLine());
        for (int c=0; c<command; c++) {
            int move = Integer.parseInt(st.nextToken());
            int[] mv = dir[move];
            if (x+mv[0]>=0 && x+mv[0]<n && y+mv[1]>=0 && y+mv[1]<m) {
                if (move == 1) { //동
                    int tmp = leri[3];
                    for (int i=0; i<3; i++) {
                        leri[3-i] = leri[2-i];
                    }
                    leri[0] = tmp;
                    updown[0] = leri[0];
                    updown[2] = leri[2];
                    head = leri[0];
                    tail = leri[2];
                }
                else if (move == 2) { //서
                    int tmp = leri[0];
                    for (int i=0; i<3; i++) {
                        leri[i] = leri[i+1];
                    }
                    leri[3] = tmp;
                    updown[0] = leri[0];
                    updown[2] = leri[2];
                    head = leri[0];
                    tail = leri[2];
                }
                else if (move == 3) { //북
                    int tmp = updown[0];
                    for (int i=0; i<3; i++) {
                        updown[i] = updown[i+1];
                    }
                    updown[3] = tmp;
                    leri[0] = updown[0];
                    leri[2] = updown[2];
                    head = updown[0];
                    tail = updown[2];
                }
                else { //남
                    int tmp = updown[3];
                    for (int i=0; i<3; i++) {
                        updown[3-i] = updown[2-i];
                    }
                    updown[0] = tmp;
                    leri[0] = updown[0];
                    leri[2] = updown[2];
                    head = updown[0];
                    tail = updown[2];
                }
                if (map[x+mv[0]][y+mv[1]] == 0) {
                    map[x+mv[0]][y+mv[1]] = dice[tail];
                }
                else {
                    dice[tail] = map[x+mv[0]][y+mv[1]];
                    map[x+mv[0]][y+mv[1]] = 0;
                }
                x += mv[0];
                y += mv[1];
                System.out.println(dice[head]);
            }
        }

    }
}