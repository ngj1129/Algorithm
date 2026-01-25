import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genToPlays = new HashMap<>();
        Map<Integer, String> playsToGen = new TreeMap<>(Comparator.reverseOrder());
        Map<String, List<List<Integer>>> genToEachPlay = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            if (!genToPlays.containsKey(g)) {
                genToPlays.put(g, 0);
                genToEachPlay.put(g, new ArrayList<>());
            }
            
            int value = genToPlays.get(g);
            value += p;
            genToPlays.put(g, value);
            
            List<List<Integer>> list = genToEachPlay.get(g);
            list.add(List.of(i, p));
        }
        // System.out.println(genToEachPlay);
        
        for (String key: genToPlays.keySet()) {
            playsToGen.put(genToPlays.get(key), key);
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (Integer key: playsToGen.keySet()) {
            String g = playsToGen.get(key);
            List<List<Integer>> list = genToEachPlay.get(g);
            list.sort(
                Comparator.<List<Integer>>comparingInt(a -> a.get(1)).reversed()
                .thenComparingInt(a -> a.get(0))
            );
            answerList.add(list.get(0).get(0));
            if (list.size() == 1) {
                continue;
            }
            answerList.add(list.get(1).get(0));
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}