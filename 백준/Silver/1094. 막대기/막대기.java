import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());	
		
		System.out.println(makeToX(64, x));
		
	
	}
	
	public static int makeToX(int num, int x) {
		if (num == x) {
			return 1;
		}
		if (num > x) {
			if (num/2 >= x) {
				return makeToX(num/2, x);
			}
			else {
				return 1 + makeToX(num/2, x-(num/2));
			}
		}
		return 0;
	}

}