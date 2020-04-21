import java.util.ArrayList;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;
		
		ArrayList<Integer>[] dp = new ArrayList[10];
		for(int i=1; i<=8; i++) {
			dp[i] = new ArrayList<Integer>();
		}
		
		String str1 = "";
		String str2 = "";
		for(int i=1; i<=8; i++) {
			str1 = "";
			str2 = "";
			for(int j=0; j<i; j++) {
				str1 += String.valueOf(N);
			}
			for(int j=0; j<str1.length()+str2.length(); j++) {
				if(str2.length() == 0) {
					dp[i].add(Integer.parseInt(str1));
				}
				else if(str1.length() == str2.length()) {
					dp[i].add(1);
				}
				else if(str1.length() < str2.length()) {
					dp[i].add(0);
					break;
				}
				else {
					dp[i].add(Integer.parseInt(str1) / Integer.parseInt(str2));
				}
				str1 = str1.substring(1);
				str2 += String.valueOf(N);
			}
			if(dp[i].contains(number)) {
				answer = i;
				break;
			}
		}
		
		
		boolean gotit = false;
		int d1 = -1;
		int d2 = -1;
		int d3 = -1;
		int d4 = -1;
		if(answer == -1) {
			for(int i=2; i<=8; i++) {
				for(int j=i-1; j>=1; j--) {
					for(int a=0; a<dp[j].size(); a++) {
						if(j < i-j) break;
						for(int b=0; b<dp[i-j].size(); b++) {
							d1 = dp[j].get(a) + dp[i-j].get(b);
							if(!dp[i].contains(d1)) dp[i].add(d1);

							d2 = dp[j].get(a) - dp[i-j].get(b);
							if(!dp[i].contains(d2)) dp[i].add(d2);

							d3 = dp[j].get(a) * dp[i-j].get(b);
							if(!dp[i].contains(d3)) dp[i].add(d3);

							if(dp[i-j].get(b) != 0) {
								d4 = dp[j].get(a) / dp[i-j].get(b);
								if(!dp[i].contains(d4)) dp[i].add(d4);
							}

							if(d1 == number || d2 == number || d3 == number || d4 == number) {
								answer = i;
								gotit = true;
								break;
							}
						}
						if(gotit == true) break;
					}
					if(gotit == true) break;
				}
				if(gotit == true) break;
			}
		}
		
		return answer;
    }
}
