// 프로그래머스 : 타겟 

class Solution {
    static int count= 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        DFS(numbers, target, 0, 0);
		answer = count;
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int n, int sum) {
		if(n == numbers.length) {
			if(sum == target)
				count++;
			return;
		}
		
		DFS(numbers, target, n+1, sum + numbers[n]);
		DFS(numbers, target, n+1, sum - numbers[n]);
	}
}
