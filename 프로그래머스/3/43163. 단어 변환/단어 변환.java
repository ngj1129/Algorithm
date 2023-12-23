class Solution {
    public int answer = 100;
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, new boolean[words.length], 0);
        if (answer == 100) {
            return 0;
        }
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            if (count < answer) {
                answer = count;
            }
            return;
        }
        for (int i=0; i<words.length; i++) {
            if (!visited[i]) {
                int idx = -1;
                boolean check = false;
                for (int ix=0; ix<words[i].length(); ix++) {
                    if (begin.charAt(ix) != words[i].charAt(ix)) {
                        if (idx != -1) {
                            check = true;
                            break;
                        }
                        idx = ix;
                    }
                }
                if (idx != -1 && !check) {
                    visited[i] = true;
                    dfs(words[i], target, words, visited, count+1);
                }
            }
        }
    }
        
}
