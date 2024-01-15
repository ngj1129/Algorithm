import java.util.Arrays;

import java.util.TreeSet;
class Solution {
    static boolean visit[];
    static int answer;
    static TreeSet<String> set;
    static int list[];

    static public int solution(String[] user_id, String[] banned_id) {
        set = new TreeSet<String>();
        visit = new boolean[user_id.length];
        list = new int[banned_id.length];

        // 이렇게하면 list banned_id 가 매핑될수있는 user_id가 생긴다. 최대 8명의 유저수이기때문에 완탐
        answer = 0;
        DFS(0, 0, user_id, banned_id);

        return answer;
    }

    public static void DFS(int cnt, int start, String[] user_id, String[] banned_id) {
        if (cnt == banned_id.length) {

            Arrays.sort(list);
            String str = Arrays.toString(list);
            if (!set.contains(str)) {
                answer++;
                set.add(str);
            }
            return;
        }

        for (int i = start; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                if (visit[j])
                    continue;
                //
                boolean isPossible = true;

                if (banned_id[j].length() != user_id[i].length()) {
                    isPossible = false;
                } else {
                    // 각각의 문자열을 비교한다
                    for (int k = 0; k < banned_id[j].length(); k++) {
                        if (banned_id[j].charAt(k) == '*')
                            continue;
                        if (banned_id[j].charAt(k) != user_id[i].charAt(k)) {
                            isPossible = false;
                            break;
                        }
                    }

                }

                if (isPossible) {
                    visit[j] = true;
                    list[cnt] = i;
                    DFS(cnt + 1, i + 1, user_id, banned_id);
                    visit[j] = false;
                }
                //

            }
        }
    }
}


// import java.util.Arrays;
// import java.util.ArrayList;

// class Solution {
//     int result = 0;
//     ArrayList<String[]> list = new ArrayList<>();
//     public int solution(String[] user_id, String[] banned_id) {
//         perm(banned_id, banned_id.length, new String[banned_id.length], new boolean[banned_id.length], 0);
//         dfs(user_id, banned_id, banned_id.length, new String[banned_id.length], 0, 0);
//         return result;
//     }
//     public void perm(String[] banned_id, int r, String[] out, boolean[] visited, int depth) {
//         if (depth == r) {
//             list.add(Arrays.copyOf(out, out.length));
//             return;
//         }
//         for (int i=0; i<banned_id.length; i++) {
//             if (!visited[i]) {
//                 out[depth] = banned_id[i];
//                 visited[i] = true;
//                 perm(banned_id, r, out, visited, depth+1);
//                 visited[i] =false;
//             }
//         }
//     }
//     public void dfs(String[] user_id, String[] banned_id, int r, String[] out, int start, int depth) {
//         if (depth == r) {
//             for (int ix=0; ix<list.size(); ix++) {
//                 String[] arr = list.get(ix);
//                 boolean check = false;
//                 for (int i=0; i<r; i++) {
//                     if (out[i].length() != arr[i].length()) {
//                         check = true;
//                         continue;
//                     }
//                     for (int j=0; j<out[i].length(); j++) {
//                         if (arr[i].charAt(j) != '*' && out[i].charAt(j) != arr[i].charAt(j)) {
//                             check = true;
//                             break;
//                         }
//                     }
//                     if (check) {
//                         break;
//                     }
//                 }
//                 if (!check) {
//                     result++;
//                     break;
//                 }
//             }
//             return;
//         }
//         for (int i=start; i<user_id.length; i++) {
//             out[depth] = user_id[i];
//             dfs(user_id, banned_id, r, out, i+1, depth+1);
//         }
//     }
// }