class Solution {
    public long solution(int N) {
        long answer = 0;
		
		long[] sum = new long[81];
		sum[1] = 4;
		sum[2] = 6;
		
		for(int i=3; i<=N; i++) {
			sum[i] = sum[i-1] + sum[i-2];
		}
		
		answer = sum[N];
		
		return answer;
    }
}
