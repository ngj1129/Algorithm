import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] arr = s.split("");
        String flag = "I";
        StringBuilder sb = new StringBuilder();
        int ix = 0;
        int answer = 0;
        int l = 0;
        while (ix < m) {
            if (arr[ix].equals(flag)) {
                sb.append(arr[ix]);
                if (flag.equals("I")) {
                    flag = "O";
                } 
                else {
                    flag = "I";
                }
            } 
            else {
                if (sb.length() > 0) {
                    if (sb.length()%2 == 0) {
                        l = (sb.length() / 2) - 1;
                    } else {
                        l = sb.length() / 2;
                    }
                    if ((l - (n-1)) > 0) {
                        answer += l - (n-1);
                    }
                    sb = new StringBuilder();
                    flag = "I";
                    continue;
                }
            }
            ix++;
        }
        if (sb.length() > 0) {
            if (sb.length()%2 == 0) {
                l = (sb.length() / 2) - 1;
            } else {
                l = sb.length() / 2;
            }
            if ((l - (n-1)) > 0) {
                answer += l - (n-1);
            }
        }
        System.out.println(answer);
    }
}