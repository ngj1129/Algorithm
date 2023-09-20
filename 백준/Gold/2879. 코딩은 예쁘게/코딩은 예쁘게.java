import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] before = new int[n];
        int[] after = new int[n];
        int[] tab = new int[n];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            before[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            after[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<n; i++) {
            tab[i] = after[i] - before[i];
        }
        int group = 0;
        int t = 0;
        int ct = 0;
        while (ct < n) {
            group = 0;
            t = 0;
            ct = 0;
            for (int i=0; i<n; i++) {
                if (group == 0) {
                    if (tab[i] != 0) {
                        group++;
                        t = tab[i];
                    } else {
                        ct++;
                    }
                    continue;
                }
                if (t * tab[i] <= 0) {
                    answer += Math.abs(t);
                    for (int j=i-group; j<i; j++) {
                        tab[j] -= t;
                    }
                    group = 0;
                    t = 0;
                    if (tab[i] != 0) {
                        group++;
                        t = tab[i];
                    } else{
                        ct++;
                    }
                }
                else {
                    group++;
                    if (tab[i] > 0) {
                        t = Math.min(t, tab[i]);
                    }
                    else {
                        t = Math.max(t, tab[i]);
                    }
                }
            }
            answer += Math.abs(t);
            for (int j=n-group; j<n; j++) {
                tab[j] -= t;
            }
        }
        System.out.println(answer);

    }
}