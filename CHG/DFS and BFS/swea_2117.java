// SWExpertAcademy 2117. 홈 방법 서비스

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int n, m;
	static int[][] map;
	static boolean[][] check;
	static int max_house, house;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			max_house = 0;
			for(int k=n+1; k>=1; k--) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						check = new boolean[n][n];
						house = 0;
						BFS(i, j, k);
						if(house*m - (k*k+(k-1)*(k-1)) >= 0) {
							if(max_house < house) {
								max_house = house;
							}
						}
					}
				}
				if(max_house > 0) break;
			}
			System.out.println("#" + test_case + " " + max_house);
		}
	}

	public static void BFS(int x, int y, int k) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qd = new LinkedList<Integer>();
		
		check[x][y] = true;
		qx.add(x);
		qy.add(y);
		qd.add(1);
		
		while(!qx.isEmpty()) {
			int vx = qx.remove();
			int vy = qy.remove();
			int vd = qd.remove();
			if(map[vx][vy] == 1) house++;
			if(vd < k) {
				vd++;
				if(vy+1 < n)
					if(check[vx][vy+1] == false) {
						check[vx][vy+1] = true;
						qx.add(vx);
						qy.add(vy+1);
						qd.add(vd);
					}
				if(vy-1 >= 0)
					if(check[vx][vy-1] == false) {
						check[vx][vy-1] = true;
						qx.add(vx);
						qy.add(vy-1);
						qd.add(vd);
					}
				if(vx+1 < n)
					if(check[vx+1][vy] == false) {
						check[vx+1][vy] = true;
						qx.add(vx+1);
						qy.add(vy);
						qd.add(vd);
					}
				if(vx-1 >= 0)
					if(check[vx-1][vy] == false) {
						check[vx-1][vy] = true;
						qx.add(vx-1);
						qy.add(vy);
						qd.add(vd);
					}
			}
		}
	}
}
