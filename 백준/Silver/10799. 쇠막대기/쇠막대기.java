import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> line = new ArrayList<>();
		int result = 0;
		
		String str = st.nextToken();
		

		str = str.replace("()", ".");
		String[] arr = str.split("");
		int[] sums = new int[arr.length];
		
		int count = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i].equals(".")) {
				count++;
			}
			sums[i] = count;
		}
	
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i].equals("(")) {
				stack.add(i);
			}
			if (arr[i].equals(")")) {
				int open = stack.pop();
				line.add(sums[i]-sums[open]+1);
			}
		}
		
		for (int i=0; i<line.size(); i++) {
			result += line.get(i);
		}
	
		
		System.out.println(result);
	
	}
}