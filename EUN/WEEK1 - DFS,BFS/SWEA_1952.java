import java.util.*;

public class Solution {
	
	static int ans, result;
	static int[] ticket;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			ticket = new int[4];
			for(int j=0;j<4;j++) {
				ticket[j] = sc.nextInt(); 
			}
			int[] plan = new int[13];
			for(int j=1;j<=12;j++) {
				plan[j] = sc.nextInt();
			}
			ans = ticket[3];
			dfs(plan, 1, 0);
			System.out.println("#" + i + " " + ans);
		}
	}
	
	public static void dfs(int[] plan, int month, int fee) {
		if(month > 12) {
			ans = Math.min(ans, fee);
			return;
		}
		
		if(plan[month] == 0) {
			dfs(plan, month+1, fee);
		}
		if(plan[month] != 0) {
			//1일 이용권 사용 시
			int fee1 = fee + plan[month] * ticket[0];
			dfs(plan, month+1, fee1);
			//1달 이용권 사용 시
			int fee2 = fee + ticket[1];
			dfs(plan, month+1, fee2);
			//3달 이용권 사용 시
			int fee3 = fee + ticket[2];
			dfs(plan, month+3, fee3);
		}
	}

}
