import java.util.HashMap;

class Solution {
    public int solution(String dirs) {
        String[] arr = dirs.split("");
        int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        HashMap<String, Integer> way = new HashMap<>();
        way.put("U", 0);
        way.put("D", 1);
        way.put("R", 2);
        way.put("L", 3);
        HashMap<Integer, Integer> other = new HashMap<>();
        other.put(0, 1);
        other.put(1, 0);
        other.put(2, 3);
        other.put(3, 2);
        boolean[][][] visited = new boolean[11][11][4];
        int answer = 0;
        int x = 5;
        int y = 5;
        for (String d: arr) {
            int i = way.get(d);
            int j = other.get(i);
            if (x + move[i][0] >= 0 && x + move[i][0] <= 10 && y + move[i][1] >= 0 && y + move[i][1] <= 10) {
                if (!visited[x][y][i]) {
                    answer++;
                }
                visited[x][y][i] = true;
                x += move[i][0];
                y += move[i][1];
                visited[x][y][j] = true;
            }
        }
        return answer;
    }
}