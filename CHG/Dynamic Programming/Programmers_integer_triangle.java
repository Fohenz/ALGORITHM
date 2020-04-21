class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
		
		int[][] max_value = new int[triangle.length][triangle.length];
		max_value[0][0] = triangle[0][0];
		for(int i=1; i<triangle.length; i++) {
			for(int j=0; j<triangle[i].length; j++) {
				if(j == 0) {
					max_value[i][j] = max_value[i-1][j] + triangle[i][j];
				}
				else if(j == triangle[i].length-1) {
					max_value[i][j] = max_value[i-1][j-1] + triangle[i][j];
				}
				else {
					int n1 = max_value[i-1][j-1];
					int n2 = max_value[i-1][j];
					if(n1 > n2)
						max_value[i][j] = max_value[i-1][j-1] + triangle[i][j];
					else
						max_value[i][j] = max_value[i-1][j] + triangle[i][j];
				}
			}
		}
		
		for(int i=0; i<max_value[max_value.length-1].length; i++) {
			if(answer < max_value[max_value.length-1][i])
				answer = max_value[max_value.length-1][i];
		}
		
		return answer;
    }
}
