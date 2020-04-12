package swExpertAcademy;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem2117 {
	
	static int n;
	static int cost;
	static int[][] city = new int[21][21];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] check = new boolean[21][21];
	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int testcase=1;testcase<=tc;testcase++) {
			n = sc.nextInt();
			cost = sc.nextInt();
			result = 0;
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					city[i][j] = sc.nextInt();
					check[i][j] = false;
				}
			}
			int home = 0;
			int finalCost = 0;
			int operationCost = 0;
			int profit = 0;
			int dep = 0;
			
			if(n%2 == 0) {
				dep = n+1;
			} else {
				dep = n;
			}
			for(int k=1;k<=dep;k++) {
				operationCost = k*k+(k-1)*(k-1);
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						check = new boolean[21][21];
						home = bfs(k,i,j);
						profit = home * cost - operationCost;
						//System.out.println(i + " " + j + " " + home);
						if(profit >= 0) {
							//System.out.println(home);
							result = Math.max(home, result);
							//System.out.println(i + " " + j + " " + k + " " + result);
						}
						//System.out.println(result);
					}
				}
			}
			if(result < 0) {
				result = 0;
			}
			System.out.println("#" + testcase + " " + result);
		}
	}
	
	public static int bfs(int k, int x, int y) {
		Queue<Index> q = new LinkedList<Index>();
		int now = 1;
		int home = 0;
		if(city[x][y] == 1) {
			home++;
		}
		check[x][y] = true;
		q.add(new Index(x,y,now));
		while(!q.isEmpty()) {
			int nx = q.peek().x;
			int ny = q.peek().y;
			int depth = q.peek().depth;
			//System.out.println(nx + " " + ny + " " + depth);
			q.poll();
			
			for(int i=0;i<4;i++) {
				x = nx + dx[i];
				y = ny + dy[i];
				if(x>=1 && x<=n && y>=1 && y<=n) {
					if(check[x][y] == false && depth<=k-1) {
						check[x][y] = true;
						q.add(new Index(x,y,depth+1));
						if(city[x][y] == 1) {
							home++;
						}
					}
				}
			}
		}
		//System.out.println("home:::: " + home);
		return home;
	}

	static class Index {
		int x;
		int y;
		int depth;
		
		public Index(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}

