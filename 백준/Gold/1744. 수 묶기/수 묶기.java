import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int zero = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                zero++;
            } else if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        Comparator<Integer> order = Collections.reverseOrder();
        Collections.sort(pos, order);
        Collections.sort(neg);
        int[] parr = new int[pos.size()];
        int[] narr = new int[neg.size()];
        
        for (int i=0; i<parr.length; i++) {
            parr[i] = pos.get(i);
        }
        for (int i=0; i<narr.length; i++) {
            narr[i] = neg.get(i);
        }

        for (int i=0; i<parr.length; i++) {
            if (parr[i] == 0 | parr[i] == 1) {
                continue;
            }
            for (int j=i+1; j<parr.length; j++) {
                if (parr[j] == 0 | parr[j] == 1) {
                    continue;
                }
                sum += parr[i] * parr[j];
                parr[i] = 0;
                parr[j] = 0;
                break;
            }
            //System.out.println(Arrays.toString(parr));
        }
        for (int i=0; i<parr.length; i++) {
            sum += parr[i];
        }
        //System.out.println(sum);

        for (int i=0; i<narr.length; i++) {
            if (narr[i] == 0) {
                continue;
            }
            for (int j=i+1; j<narr.length; j++) {
                if (narr[j] == 0) {
                    continue;
                }
                sum += narr[i] * narr[j];
                narr[i] = 0;
                narr[j] = 0;
                break;
            }
        }

        for (int i=0; i<narr.length; i++) {
            if (narr[i] < 0) {
                if (zero > 0) {
                    zero--;
                }
                else {
                    sum += narr[i];
                }
            }
        }
        System.out.println(sum);
    }
}