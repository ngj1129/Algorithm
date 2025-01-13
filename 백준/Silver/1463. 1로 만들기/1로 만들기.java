import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];

        // dp 배열 초기화
        for (int i = 0; i <= N; i++) {
            dp[i] = -1; // 아직 계산되지 않은 값을 -1로 설정
        }

        dp[0] = 0; // 문제의 조건에 따라 0에서 0으로 가는 경우는 0번
        dp[1] = 0; // 1에서 1로 가는 경우도 0번

        System.out.println(divide(N));
    }

    public static int divide(int num) {
        if (dp[num] != -1) { // 이미 계산된 값이면 그대로 반환
            return dp[num];
        }

        dp[num] = Integer.MAX_VALUE; // 초기 값 설정

        // 세 가지 경우를 계산
        if (num % 3 == 0) {
            dp[num] = Math.min(divide(num / 3) + 1, dp[num]);
        }
        if (num % 2 == 0) {
            dp[num] = Math.min(divide(num / 2) + 1, dp[num]);
        }
        dp[num] = Math.min(divide(num - 1) + 1, dp[num]);

        return dp[num];
    }
}
