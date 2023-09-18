import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String word = br.readLine();
        int l = word.length();
        int i = 0;
        int answer = 0;
        while (i <= str.length()-l) {
            if (word.equals(str.substring(i, i+l))) {
                answer++;
                i += l;
                continue;
            }
            else {
                i++;
            }
        }
        System.out.println(answer);

    }
}