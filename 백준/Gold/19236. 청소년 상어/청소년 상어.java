import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int answer = 0;

    public static void dfs(HashMap<Integer, int[]> dir, HashMap<Integer, int[]> pos, HashMap<Integer, Integer> pos_num, 
    HashMap<Integer, int[]> arr, int[][] map, int s, int s_num, int[] s_cur, int[] s_d, int sum) {
        //물고기 이동
        for(int fish=1; fish<=16; fish++) {
            int[] cur = pos.get(fish); //현재 물고기 위치
            if (map[cur[0]][cur[1]] != fish) { //물고기 존재 X
                continue;
            }
            int d_num = pos_num.get(fish); //현재 물고기 방향 숫자
            int[] d = arr.get(fish); //현재 물고기 방향

            for (int i=0; i<9; i++) {
                if (cur[0]+d[0] >= 0 && cur[0]+d[0] < 4 && cur[1]+d[1] >= 0 && cur[1]+d[1] < 4) {
                    if (map[cur[0]+d[0]][cur[1]+d[1]] >= 0) { 
                        int change = map[cur[0]+d[0]][cur[1]+d[1]];//빈칸 or 경계 안 넘을 때
                        if (map[cur[0]+d[0]][cur[1]+d[1]] > 0) {
                            pos.put(change, new int[]{cur[0], cur[1]});
                        }
                        pos.put(fish, new int[]{cur[0]+d[0], cur[1]+d[1]});
                        map[cur[0]+d[0]][cur[1]+d[1]] = fish;
                        map[cur[0]][cur[1]] = change;
                        pos_num.put(fish, d_num);
                        arr.put(fish, d);
                        break;
                    }
                }
                //이동 못했을 때 방향 변경
                d_num++;
                if (d_num > 8) {
                    d_num = d_num%8;
                }
                //방향 숫자 반시계방향 +1
                d = dir.get(d_num); //방향 변경

            }
           
            // System.out.println("------------------------"+fish+"--------------------");
            // for (int i=0; i<4; i++) {
            //     System.out.println(Arrays.toString(map[i]));
            // }
            // for (int i=1; i<=16; i++) {
            //     System.out.print(i + " ");
            //     System.out.println(pos_num.get(i));
            // }
        }
   
        //상어 이동
        int[] move = new int[2];
        move[0] = s_cur[0];
        move[1] = s_cur[1];
        for (int ct = 0; ct<3; ct++) {
            move[0] += s_d[0];
            move[1] += s_d[1];
            if (move[0] >= 0 && move[0] < 4 && move[1] >= 0 && move[1] < 4) {
                if (map[move[0]][move[1]] > 0) {
                    int eat = map[move[0]][move[1]];
                    int eat_num = pos_num.get(eat);
                    int[] e = arr.get(eat);

                    //먹는다
                    map[move[0]][move[1]] = -1;
                    map[s_cur[0]][s_cur[1]] = 0;
                    HashMap<Integer, int[]> pos1 = new HashMap<>(pos); //물고기 -> 현재 위치
                    HashMap<Integer, Integer> pos_num1 = new HashMap<>(pos_num); //물고기 -> 방향 숫자
                    HashMap<Integer, int[]> arr1 = new HashMap<>(arr); //물고기 -> 방향
                    int[][] map1 = new int[4][4];
                    for (int i=0; i<4; i++) {
                        for (int j=0; j<4; j++) {
                            map1[i][j] = map[i][j];
                        }
                    }

                    dfs(dir, pos1, pos_num1, arr1, map1, eat, eat_num, new int[]{move[0], move[1]}, new int[]{e[0], e[1]}, sum+eat); 
                    // System.out.println("---------------return--------------");
                    // for (int i=0; i<4; i++) {
                    //     System.out.println(Arrays.toString(map[i]));
                    // }
                    // for (int i=1; i<=16; i++) {
                    //     System.out.print(i + " ");
                    //     System.out.println(pos_num.get(i));
                    // }
                    map[move[0]][move[1]] = eat;
                    map[s_cur[0]][s_cur[1]] = -1;

                }
            }
        }
        if (sum > answer) {
            answer = sum;
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[4][4];
        HashMap<Integer, int[]> dir = new HashMap<>(); //방향 정보
        HashMap<Integer, int[]> pos = new HashMap<>(); //물고기 -> 현재 위치
        HashMap<Integer, Integer> pos_num = new HashMap<>(); //물고기 -> 방향 숫자
        HashMap<Integer, int[]> arr = new HashMap<>(); //물고기 -> 방향
        dir.put(1, new int[]{-1, 0});
        dir.put(2, new int[]{-1, -1});
        dir.put(3, new int[]{0, -1});
        dir.put(4, new int[]{1, -1});
        dir.put(5, new int[]{1, 0});
        dir.put(6, new int[]{1, 1});
        dir.put(7, new int[]{0, 1});
        dir.put(8, new int[]{-1, 1});
       
        for (int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<8; j++) {
                if (j%2 == 0) {
                    map[i][j/2] = Integer.parseInt(st.nextToken());
                    pos.put(map[i][j/2], new int[]{i, j/2});
                }
                else {
                    int num = Integer.parseInt(st.nextToken());
                    int[] arrow = dir.get(num);
                    arr.put(map[i][j/2], arrow);
                    pos_num.put(map[i][j/2], num);
                }
            }
        }
        int start = map[0][0];

        map[0][0] = -1;
    
        // for (int i=1; i<=16; i++) {
        //     System.out.print(i + " ");
        //     System.out.print(Arrays.toString(pos.get(i)) + " ");
        //     System.out.print(pos_num.get(i) + " ");
        //     System.out.println(Arrays.toString(arr.get(i)));
        // }

        // HashMap<Integer, int[]> pos1 = new HashMap<>(pos); //물고기 -> 현재 위치
        // HashMap<Integer, Integer> pos_num1 = new HashMap<>(pos_num); //물고기 -> 방향 숫자
        // HashMap<Integer, int[]> arr1 = new HashMap<>(arr); //물고기 -> 방향
        // int[][] map1 = new int[4][4];
        // for (int i=0; i<4; i++) {
        //     for (int j=0; j<4; j++) {
        //         map1[i][j] = map[i][j];
        //     }
        // }
    
        dfs(dir, pos, pos_num, arr, map, start, pos_num.get(start), new int[]{0, 0}, arr.get(start), start); 
        System.out.println(answer);
        // System.out.println(answer);
        // for (int i=0; i<4; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        // for (int i=1; i<=16; i++) {
        //     System.out.print(i + " ");
        //     System.out.print(Arrays.toString(pos.get(i)) + " ");
        //     System.out.print(pos_num.get(i) + " ");
        //     System.out.println(Arrays.toString(arr.get(i)));
        // }
    }

    //↑, ↖, ←, ↙, ↓, ↘, →, ↗ 
}
