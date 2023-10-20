import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int lastElement1 = o1[0];
                int lastElement2 = o2[0];
                return Integer.compare(lastElement1, lastElement2);
            }
        });
        for (int i=0; i<n; i++) {
            if (pq.isEmpty()) {
                pq.offer(arr[i][1]);
                answer++;
            }
            else {
                if (arr[i][0] < pq.peek()) {
                    pq.offer(arr[i][1]);
                    answer++;
                }
                else {
                    pq.poll();
                    pq.offer(arr[i][1]);
                }
            }
        }
        System.out.println(answer);
    }      
}