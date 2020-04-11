// 7733. 치즈 도둑

import java.util.Scanner;

public class Solution {
	
	static int[][] cheese;
	static boolean[][] visit;
	static int max_value;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			
			cheese = new int[n+1][n+1];
			visit = new boolean[n+1][n+1];
			
			int max_cheese = 0;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					cheese[i][j] = sc.nextInt();
					if(max_cheese < cheese[i][j]) max_cheese = cheese[i][j];
				}
			}
			
			max_value = 1;
			
			for(int d=1; d<=max_cheese; d++) {
				int count = 0;
				
				for(int i=1; i<=n; i++) {
					for(int j=1; j<=n; j++) {
						visit[i][j] = false;
						if(cheese[i][j] <= d)  {
							cheese[i][j] = 0;
							visit[i][j] = true;
						}
					}
				}
				
				for(int i=1; i<=n; i++) {
					for(int j=1; j<=n; j++) {
						if(cheese[i][j] != 0 && visit[i][j] == false) {
							DFS(i, j);
							count++;
						}
					}
				}
				
				if(max_value < count) max_value = count;
			}
			
			System.out.println("#" + test_case + " " + max_value);
		}
	}

	public static void DFS(int x, int y) {
		if(x<1 || y<1 || x>n || y>n) return;
		if(cheese[x][y] == 0) return;
		if(visit[x][y] == true) return;
		
		visit[x][y] = true;
		
		DFS(x, y+1);
		DFS(x, y-1);
		DFS(x+1, y);
		DFS(x-1, y);
	}
}
