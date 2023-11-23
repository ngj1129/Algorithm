import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        HashMap<String, Integer> way = new HashMap<>();
        way.put("E", 0);
        way.put("W", 1);
        way.put("S", 2);
        way.put("N", 3);
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int n = park.length;
        int m = park[0].length();
        int[] start = new int[2];
        String[][] map = new String[n][m];
        for (int i=0; i<n; i++) {
            map[i] = park[i].split("");
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int[] xy = new int[2];
        for (int i=0; i<routes.length; i++) {
            boolean check = false;
            int ix = way.get(routes[i].substring(0, 1));
            int num = Integer.valueOf(routes[i].substring(2, 3));
            int x = 0;
            int y = 0;
            for (int j=1; j<=num; j++) {
                int[] arr = {move[ix][0]*j, move[ix][1]*j};
                x = start[0] + arr[0];
                y = start[1] + arr[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (map[x][y].equals("X")) {
                        check = true;
                        break;
                    }
                }
                else {
                    check = true;
                    break;
                }
            }
            if (!check) {
                start[0] = x;
                start[1] = y;
            }
            
        }
        return start;
    }
}