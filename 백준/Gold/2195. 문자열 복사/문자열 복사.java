import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        int i = 0;
        int j = 1;
        int answer = 1;
        while (j <= p.length()) {
            if (s.contains(p.substring(i, j))) {
                j++;
            } else {
                i = j-1;
                j = i+1;
                answer++;
            }
        }
        System.out.println(answer);
    }
}