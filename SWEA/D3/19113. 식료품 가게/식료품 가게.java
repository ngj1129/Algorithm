import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> priceList = new ArrayList<>();
            while (st.hasMoreTokens()) {
                priceList.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> price = new ArrayList<>();

            while (!priceList.isEmpty()) {
                for (int i = 0; i < priceList.size(); i++) {
                    int num = priceList.get(i);
                    int reduced = (int) (num * (3.0 / 4));
                    if (num % 4 == 0 && priceList.contains(reduced)) {
                        price.add(reduced);
                        priceList.remove(i); // 현재 값 제거
                        priceList.remove(Integer.valueOf(reduced)); // reduced 값 제거
                        break;
                    }
                }
            }

            System.out.print("#" + t + " ");
            for (int p : price) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}
