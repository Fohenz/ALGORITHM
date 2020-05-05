class Solution {
    public int solution(int[] left, int[] right) {
        int answer = 0;
		
		int[][] dp = new int[left.length+1][right.length+1];
		
		for(int i=0; i<left.length; i++) {
			for(int j=0; j<right.length; j++) {
				dp[i][j] = -1;
			}
		}
		
		dp[0][0] = 0;
		
		for(int i=0; i<left.length; i++) {
			for(int j=0; j<right.length; j++) {
				if(dp[i][j] == -1) continue;
				if(left[i] > right[j] && dp[i][j+1] < dp[i][j] + right[j]) dp[i][j+1] = dp[i][j] + right[j];
				if(dp[i+1][j] < dp[i][j]) dp[i+1][j] = dp[i][j];
				if(dp[i+1][j+1] < dp[i][j]) dp[i+1][j+1] = dp[i][j];
			}
		}
		
		for(int i=0; i<left.length+1; i++) {
			for(int j=0; j<right.length+1; j++) {
				if(answer < dp[i][j]) answer = dp[i][j];
			}
		}
		
		return answer;
    }
}
