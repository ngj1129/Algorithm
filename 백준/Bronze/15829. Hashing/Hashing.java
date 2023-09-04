import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
    
        String s = new String(br.readLine());
        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            int num = ((int) s.charAt(i) - 96) * (int) Math.pow(31, i);
            sum += num;
        }
        if (sum >= 1234567891)
            System.out.println(sum/1234567891);
        else
            System.out.println(sum);


        
    }
}