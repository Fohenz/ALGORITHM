class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
		
		int[][] map = new int[101][101];
		
		for(int i=0; i<puddles.length; i++) {
			map[puddles[i][1]][puddles[i][0]] = -1;
		}
		
		boolean trap = false;
		for(int i=1; i<=n; i++) {
			if(map[i][1] == -1) {
				trap = true;
			}
			else {
				if(trap == true) {
					map[i][1] = -1;
				}
				else {
					map[i][1] = 1;
				}
			}
		}
		trap = false;
		for(int i=1; i<=m; i++) {
			if(map[1][i] == -1) {
				trap = true;
			}
			else {
				if(trap == true) {
					map[1][i] = -1;
				}
				else {
					map[1][i] = 1;
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=m; j++) {
				if(map[i][j] != -1) {
					if(i==0 || j==0) {
						map[i][j] = 1;
					}
					else {
						if(map[i-1][j] == -1 && map[i][j-1] != -1) map[i][j] = map[i][j-1];
						else if(map[i-1][j] != -1 && map[i][j-1] == -1) map[i][j] = map[i-1][j];
						else if(map[i-1][j] == -1 && map[i][j-1] == -1) map[i][j] = 0;
						else map[i][j] = Math.floorMod(map[i][j-1] + map[i-1][j], 1000000007);
					}
				}
			}
		}
		
		answer = map[n][m];
		return answer;
    }
}
