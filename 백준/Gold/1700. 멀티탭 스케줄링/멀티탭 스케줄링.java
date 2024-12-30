import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
    public static int[] arr;
    public static int[] used;
    public static ArrayList<Queue<Integer>> list;
    public static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;

        arr = new int[K];
        used = new int[N];
        Arrays.fill(used, -1); // -1로 초기화하여 빈 슬롯 표시
        list = new ArrayList<Queue<Integer>>();

        for (int i = 0; i <= 100; i++) { 
            list.add(new LinkedList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.get(arr[i]).add(i); // 각 전기 용품의 사용 시점을 큐에 추가
        }

        for (int i = 0; i < K; i++) {
            int cur = arr[i];
            list.get(cur).poll(); // 현재 시간 제거

            boolean isPlugged = false;
            for (int j = 0; j < N; j++) {
                if (used[j] == cur) { // 이미 꽂혀 있는 경우
                    isPlugged = true;
                    break;
                }
            }

            if (isPlugged) continue;

            boolean emptySlot = false;
            for (int j = 0; j < N; j++) {
                if (used[j] == -1) { 
                    used[j] = cur;
                    emptySlot = true;
                    break;
                }
            }

            if (emptySlot) {
                continue;
            }

            // 교체가 필요한 경우
            int lastTime = -1;
            int replaceIdx = -1;
            for (int j = 0; j < N; j++) {
                int cand = used[j];
                if (list.get(cand).isEmpty()) { // 더 이상 사용되지 않는 경우
                    replaceIdx = j;
                    break;
                }
                int nextUse = list.get(cand).peek(); // 다음 사용 시점
                if (nextUse > lastTime) {
                    lastTime = nextUse;
                    replaceIdx = j;
                }
            }

            used[replaceIdx] = cur; // 교체
            count++;
        }

        System.out.println(count);
    }
}
