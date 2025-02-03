import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sums = new long[N]; // 누적 합의 나머지를 저장할 배열
        int[] rems = new int[M];   // 나머지 값 카운트 배열

        st = new StringTokenizer(br.readLine());

        long sum = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken()); // Ai를 직접 누적
            sum %= M;  // 누적 합을 M으로 나눈 나머지 계산

            if (sum < 0) sum += M; // 음수 방지

            sums[i] = sum;
            rems[(int) sum]++;  // 해당 나머지 개수 증가
        }

        result += rems[0]; // 나머지가 0인 구간 카운트 추가

        for (int i = 0; i < M; i++) {
            if (rems[i] >= 2) {
                result += (long) rems[i] * (rems[i] - 1) / 2;
            }
        }

        System.out.println(result);
    }
}
