class Solution {
    public int solution(String[] board) {
        int o = 0;
        int owin = 0;
        int x = 0;
        int xwin = 0;
        String[][] arr = new String[3][3];
        for (int i=0; i<3; i++) {
            arr[i] = board[i].split("");
        }
        for (String str: board) {
            for (int i=0; i<3; i++) {
                if (str.charAt(i) == 'O') {
                    o++;
                }
                else if (str.charAt(i) == 'X') {
                    x++;
                }
            }
        }
        if (x > o | o-x > 1) {
            return 0;
        }
        for (int i=0; i<3; i++) {
            if (arr[i][0].equals("O") && arr[i][1].equals("O") && arr[i][2].equals("O")) {
                owin++;
            }
            if (arr[i][0].equals("X") && arr[i][1].equals("X") && arr[i][2].equals("X")) {
                xwin++;
            }
            if (arr[0][i].equals("O") && arr[1][i].equals("O") && arr[2][i].equals("O")) {
                owin++;
            }
            if (arr[0][i].equals("X") && arr[1][i].equals("X") && arr[2][i].equals("X")) {
                xwin++;
            }
        }
        if (arr[0][0].equals("O") && arr[1][1].equals("O") && arr[2][2].equals("O")) {
            owin++;
        }
        if (arr[0][0].equals("X") && arr[1][1].equals("X") && arr[2][2].equals("X")) {
            xwin++;
        }
        if (arr[0][2].equals("O") && arr[1][1].equals("O") && arr[2][0].equals("O")) {
            owin++;
        }
        if (arr[0][2].equals("X") && arr[1][1].equals("X") && arr[2][0].equals("X")) {
            xwin++;
        }
        if (owin > 1 | xwin > 1) {
            if (o+x != 9) {
                return 0;
            }
        }
        if (xwin == 1 && owin == 1) {
            return 0;
        }
        if (xwin == 1) {
            if (o != x) {
                return 0;
            }
        }
        if (owin == 1) {
            if (o <= x) {
                return 0;
            }
        }
        return 1;
    }
}