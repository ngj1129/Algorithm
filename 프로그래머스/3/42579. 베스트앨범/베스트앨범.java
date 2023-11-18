import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> g_ix = new HashMap<>();
        HashMap<String, Integer> g_sum = new HashMap<>();
        HashMap<Integer, ArrayList<int[]>> ix_play = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        int ix = -1;
        int count = 0;
        int k = 0;
        for (int i=0; i<genres.length; i++) {
            if (g_ix.containsKey(genres[i])) {
                count = g_sum.get(genres[i]);
                k = g_ix.get(genres[i]);
                list = ix_play.get(k);
            }
            else {
                ix++;
                g_ix.put(genres[i], ix);
                k = ix;
                count = 0;
                list = new ArrayList<>();
            }
            count += plays[i];
            g_sum.put(genres[i], count);
            list.add(new int[]{i, plays[i]});
            ix_play.put(k, list);
        }
        int n = g_ix.size();
        int[][] sum_arr = new int[n][2];
        ix = 0;
        for (String key: g_ix.keySet()) {
            sum_arr[ix][0] = g_ix.get(key);
            sum_arr[ix][1] = g_sum.get(key);
            ix++;
        }
        Arrays.sort(sum_arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a2[1], a1[1]);
            }
        });
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            ix = sum_arr[i][0];
            list = ix_play.get(ix);
            int[][] arr = new int[list.size()][2];
            for (int j=0; j<list.size(); j++) {
                arr[j][0] = list.get(j)[0];
                arr[j][1] = list.get(j)[1];
            }
            Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]).reversed());
            answer.add(arr[0][0]);
            if (arr.length > 1) {
                answer.add(arr[1][0]);
            }
        }
        int[] as = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) {
            as[i] = answer.get(i);
        }
        return as;
    }
}