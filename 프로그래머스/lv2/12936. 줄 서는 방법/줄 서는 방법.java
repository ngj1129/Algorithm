import java.util.ArrayList;
class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
        }
        long m = 1;
        for (int i=2; i<=n; i++) {
            m *= i;
        }
       
        for (int i=n; i>0; i--) {
            m /= i;
            int fir = (int) (k / m);
            long tmp = k % m;
            if (tmp == 0) {
                tmp = m;
                fir--;
            }
            int num = list.get(fir);
            answer.add(num);
            list.remove(fir);
            k = tmp;
        }
        for (int i=0; i<n; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
/*
class Solution {
    long ct;
    long ix;
    int[] out;
    boolean check;
    
    public int[] solution(int n, long k) {
        ct = 0;
        out = new int[n-1];
        int[] answer = new int[n];
        int[] arr = new int[n-1];
        int[] tmp = new int[n-1];
        boolean[] visited = new boolean[n-1];
        
        long m = 1;
        for (int i=2; i<n; i++)
            m *= i;
        
        int fir = (int) (k / m);
        ix = k % m;
        if (ix == 0)
            ix = m;
        else
            fir++;
        answer[0] = fir;
        
        int j = 1;
        for (int i=0; i<n-1; i++) {
            if (j==fir) {
                arr[i] = j+1;
                j += 2;
                continue;
            }
            arr[i] = j;
            j++;
        }
        perm(arr, tmp, visited, 0, n-1);
        for (int i=1; i<n; i++)
            answer[i] = out[i-1];
        return answer;
    }
    
    public void perm(int[] arr, int[] tmp, boolean[] visited, int depth, int r) {
        if (check)
            return;
        if (depth == r) {
            ct++;
            if (ct == ix) {
                for (int j=0; j<arr.length; j++) 
                    out[j] = tmp[j];
                check = true;
            }
            return;
        }
        
        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                tmp[depth] = arr[i];
                visited[i] = true;
                perm(arr, tmp, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
*/