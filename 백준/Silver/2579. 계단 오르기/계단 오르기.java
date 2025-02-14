import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int[][] dp;
    public static int[] stair;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        dp = new int[n + 1][2]; // dp 배열 초기화
        stair = new int[n + 1]; // 계단 점수 배열

        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine().trim());
        }

        // 정답 출력 (n번째 계단에서의 최대 점수)
        System.out.println(Math.max(solve(n, 0), solve(n, 1)));
    }

    // solve(n, c): n번째 계단까지 도달했을 때 얻을 수 있는 최대 점수
    // c == 0: 한 칸 전에서 올라온 경우
    // c == 1: 두 칸 전에서 올라온 경우
    public static int solve(int n, int c) {
        if (n == 0) return 0; // 시작점
        if (n == 1) return stair[1]; // 첫 번째 계단

        if (dp[n][c] != -1) return dp[n][c]; // 이미 계산된 값이면 반환

        if (c == 0) {
            // 한 칸 전에서 올라왔으므로 이전 계단을 두 칸 전에서 온 경우만 가능
            dp[n][c] = solve(n - 1, 1) + stair[n];
        } else {
            // 두 칸 전에서 올라온 경우
            dp[n][c] = Math.max(solve(n - 2, 0), solve(n - 2, 1)) + stair[n];
        }
        
        return dp[n][c];
    }
}
