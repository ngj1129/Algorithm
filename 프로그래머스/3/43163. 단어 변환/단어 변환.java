import java.util.*;

class Solution {
    public static class Word {
        public String str;
        public int count;
        
        public Word(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Word(begin, 0));
        while (!queue.isEmpty()) {
            Word word = queue.poll();
            if (word.str.equals(target)) {
                return word.count;
            }
            for (int i=0; i<words.length; i++) {
                if (!visited[i] && canChange(word.str, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], word.count+1));
                }
            }
        }
        return 0;
    }
    
    public boolean canChange(String before, String after) {
        int diff = 0;
        for (int i=0; i<before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        }
        return false;
    }
}