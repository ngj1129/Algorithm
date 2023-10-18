import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        int[] s_arr = new int[set.size()];
        int ix = 0;
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            s_arr[ix] = iter.next();
            ix++;
        }
        Arrays.sort(s_arr);
        for (int i=0; i<s_arr.length; i++) {
            map.put(s_arr[i], i);
        }
        StringBuilder sb = new StringBuilder();

        for (int num: arr) {
            sb.append(map.get(num) + " ");
        }
        System.out.println(sb.toString());
    }      
}