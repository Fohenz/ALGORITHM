import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class problem9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			System.out.println(chkVps(input));
		}
	}

	public static String chkVps(String vps) {
		Stack<String> st = new Stack<String>();
		StringBuffer sb = new StringBuffer(vps);
		st.clear();

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '(') {
				st.push(String.valueOf(sb.charAt(i)));
			} 
			else if (sb.charAt(i) == ')') {
				try {
				st.pop();
				}catch (EmptyStackException e) {
					return "NO";
				}
			}
		}
		
		if(st.size() > 0) {
			return "NO";
		}
		else {
			return "YES";
		}
	}
}
