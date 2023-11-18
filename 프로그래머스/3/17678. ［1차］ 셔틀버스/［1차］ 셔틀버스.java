import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] bus = new int[n];
        int[] crew = new int[timetable.length];
        int time = 540;
        int conn = 0;
        for (int i=0; i<n; i++) {
            bus[i] = time;
            time += t;
        }
        
        for (int i=0; i<crew.length; i++) {
            int hr = Integer.valueOf(timetable[i].substring(0, 2));
            int mt = Integer.valueOf(timetable[i].substring(3, 5));
            crew[i] = hr*60 + mt;
        }
        Arrays.sort(crew);
        //System.out.println(Arrays.toString(bus));
        //System.out.println(Arrays.toString(crew));
        int b = 0;
        int c = 0;
        int count = 0;
        while (b < n-1 && c < crew.length) {
            if (count < m) {
                if (crew[c] <= bus[b]) { //버스보다 일찍와야 탈수있음
                    count++;
                    c++;
                    continue;
                }
            }
            b++;
            count = 0;
        }
        
        if (crew.length-c < m) {
            conn = bus[bus.length-1];
            return TimeFormat(conn);
        }
        
        int last = 0;
        int check = 0;
        boolean flag = false;
        
        while (c < crew.length && check < m) {
            if (crew[c] <= bus[b]) {
                last = crew[c];
                check++;
                c++;
            }
            else {
                flag = true;
                conn = bus[bus.length-1];
                break;
            }
        } 
        if (!flag) {
            conn = last-1;
        }
        return TimeFormat(conn);
    }
    
    public String TimeFormat(int time) {
        StringBuilder sb = new StringBuilder();
        if (time/60 < 10) {
            sb.append("0");
        }
        sb.append(time/60);
        sb.append(":");
        if (time%60 < 10) {
            sb.append("0");
        }
        sb.append(time%60);
        return sb.toString();
    }
        
}