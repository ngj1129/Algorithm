import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = (int) Math.pow(2, k) - 1;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }
        treeorder(arr, 0);
        for (int key: tree.keySet()) {
            for (int num: tree.get(key)) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println("");
        } 
    }
    
    public static void treeorder(int[] arr, int depth) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length == 1) {
            if (tree.containsKey(depth)) {
                list = tree.get(depth);
            }
            list.add(arr[0]);
            tree.put(depth, list);
            return;
        }
        int ix = (int) arr.length/2;
        if (tree.containsKey(depth)) {
            list = tree.get(depth);
        }
        list.add(arr[ix]);
        tree.put(depth, list);
        treeorder(Arrays.copyOfRange(arr, 0, ix), depth+1);
        treeorder(Arrays.copyOfRange(arr, ix+1, arr.length), depth+1);
    }

}