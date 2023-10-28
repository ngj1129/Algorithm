import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] solution = new long[N];
        ArrayList<Long> n = new ArrayList<>();
        ArrayList<Long> p = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            solution[i] = Long.parseLong(st.nextToken());
            if (solution[i] < 0) {
                n.add(solution[i]);
            } else {
                p.add(solution[i]);
            }
        }
        long[] neg = new long[n.size()];
        long[] pos = new long[p.size()];
        for (int i = 0; i < neg.length; i++) {
            neg[i] = n.get(i);
        }
        for (int i = 0; i < pos.length; i++) {
            pos[i] = p.get(i);
        }
        Arrays.sort(neg);
        Arrays.sort(pos);
        if (neg.length == 0) {
            System.out.println(pos[0] + " " + pos[1]);
        } else if (pos.length == 0) {
            System.out.println(neg[neg.length - 2] + " " + neg[neg.length - 1]);
        } else {
            long sol;
            int i;
            int j;
            int mid;
            long n_min = 0;
            long p_min = 0;
            long diff = 2000000000;
            boolean flag = false;
            if (neg.length > 1) {
                if (Math.abs(neg[neg.length - 2] + neg[neg.length - 1]) < diff) {
                    diff = Math.abs(neg[neg.length - 2] + neg[neg.length - 1]);
                    n_min = neg[neg.length - 2];
                    p_min = neg[neg.length - 1];
                }
            }
            if (pos.length > 1) {
                if (pos[0]+pos[1] < diff) {
                    diff = pos[0]+pos[1];
                    n_min = pos[0];
                    p_min = pos[1];
                }
            }
            for (int ix = 0; ix < neg.length; ix++) {
                sol = Math.abs(neg[ix]);
                i = 0;
                j = pos.length - 1;
                mid = (i + j) / 2;
                while (i <= j) {
                    if (pos[mid] == sol) {
                        flag = true;
                        n_min = neg[ix];
                        p_min = pos[mid];
                        break;
                    } else if (pos[mid] > sol) {
                        if ((pos[mid] - sol) < diff) {
                            diff = pos[mid] - sol;
                            n_min = neg[ix];
                            p_min = pos[mid];
                        }
                        j = mid - 1;
                        mid = (i + j) / 2;
                    } else {
                        if ((sol - pos[mid]) < diff) {
                            diff = sol - pos[mid];
                            n_min = neg[ix];
                            p_min = pos[mid];
                        }
                        i = mid + 1;
                        mid = (i + j) / 2;
                    }
                }
                if (flag) {
                    break;
                }
            }
            System.out.println(n_min + " " + p_min);
        }

    }
}