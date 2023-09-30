import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());
        abab(s, t);
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    public static void abab(StringBuilder s, StringBuilder t) {
        if (s.toString().equals(t.toString())) {
            flag = true;
            return;
        }
        if (s.length() < t.length()) {
            if (t.charAt(t.length()-1) == 'A') {
                abab(s, new StringBuilder(t).delete(t.length()-1, t.length()));
            }
            if (t.charAt(0) == 'B') {
                abab(s, new StringBuilder(t).reverse().delete(t.length()-1, t.length()));
            }
        }
    }
}