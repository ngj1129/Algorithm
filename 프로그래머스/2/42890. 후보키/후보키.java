import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    int result = 0;
    ArrayList<int[]> list = new ArrayList<>();
    public int solution(String[][] relation) {
        int col = relation[0].length;
        int row = relation.length;
        for (int c=1; c<=col; c++) {
            comb(relation, row, col, c, new int[c], 0, 0);
        }
        boolean[] check = new boolean[list.size()];
        for (int i=0; i<list.size(); i++) {
            HashSet<Integer> s1 = new HashSet<>();
            for (int j=0; j<list.get(i).length; j++) {
                s1.add(list.get(i)[j]);
            }
            for (int k=i+1; k<list.size(); k++) {
                HashSet<Integer> s2 = new HashSet<>();
                HashSet<Integer> inter = new HashSet<>(s1);
                for (int j=0; j<list.get(k).length; j++) {
                    s2.add(list.get(k)[j]);
                }
                inter.retainAll(s2);
                if (s1.equals(inter)) {
                    check[k] = true;
                }
            }
        }
        for (int i=0; i<check.length; i++) {
            if (!check[i]) {
                result++;
            }
        }
        return result;
    }
    public void comb(String[][] relation, int row, int n, int r, int[] out, int start, int depth) {
        if (depth == r) {
            HashSet<String> set = new HashSet<>();
            for (int i=0; i<row; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<r; j++) {
                    sb.append(relation[i][out[j]]);
                }
                set.add(sb.toString());
            }
            if (row == set.size()) {
                int[] arr = new int[out.length];
                for (int i=0; i<arr.length; i++) {
                    arr[i] = out[i];
                }
                list.add(arr);
            }
            return;
        }
        for (int i=start; i<n; i++) {
            out[depth] = i;
            comb(relation, row, n, r, out, i+1, depth+1);
        }
    }
}