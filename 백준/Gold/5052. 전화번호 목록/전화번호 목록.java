import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;
            String[] arr = new String[n];
            HashMap<String, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr, (str1, str2) -> {
                Long num1 = Long.parseLong(str1);
                Long num2 = Long.parseLong(str2);
                return num1.compareTo(num2);
            });
            for (int i=0; i<n; i++) {
                for (int j=1; j<=arr[i].length(); j++) {
                    String str = arr[i].substring(0, j);
                    if (map.containsKey(str)) {
                        int count = map.get(str);
                        map.put(str, ++count);
                    }
                    else {
                        map.put(str, 1);
                    }
                }
            }
            for (int i=0; i<n; i++) {
                if (map.containsKey(arr[i])) {
                    if (map.get(arr[i]) > 1) {
                        flag = true;
                        break;
                    } 
                }
            }
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
        
    }      
}