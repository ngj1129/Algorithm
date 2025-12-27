class Solution {
    public static int count;
    
    public int solution(String begin, String target, String[] words) {
        count = 0;
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        return count;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int depth) {
        if (begin.equals(target)) {
            if (count == 0 | depth < count) {
                count = depth;
                return;
            }
        }
        for (int i=0; i<words.length; i++) {
            if (!visited[i] && canChange(begin, words[i])) {
                visited[i] = true;
                // System.out.println(words[i]);
                dfs(words[i], target, words, visited, depth+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean canChange(String begin, String str) {
        int diff = 0;
        for (int i=0; i<begin.length(); i++) {
            if (begin.charAt(i) != str.charAt(i)) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        }
        return false;
    }
}