import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
    
        for (int i=0; i<l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String man = st.nextToken();
            String state = st.nextToken();
            map.put(man, state);
        }
        for (String k: map.keySet()) {
            if (map.get(k).equals("enter"))
                list.add(k);
        }
        String[] arr = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for (int i=arr.length-1; i>=0; i--) {
            System.out.println(arr[i]);
        }
      
        
    }
}