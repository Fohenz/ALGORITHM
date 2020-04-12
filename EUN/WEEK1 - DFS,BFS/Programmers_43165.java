class Solution {
    static int result;
    static int tar;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        tar = target;
        dfs(numbers, 0, 0);
        answer = result;
        return answer;
    }
    
    public static void dfs(int[] numbers, int idx, int sum) {
        if(idx == numbers.length) {
        	if(sum == tar) {
        		result++;
        	}
        	return;
        }
        dfs(numbers, idx+1, sum+numbers[idx]);
        dfs(numbers, idx+1, sum-numbers[idx]);
    }
}
