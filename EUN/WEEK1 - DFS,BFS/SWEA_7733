package swExpertAcademy;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem7733 {

	static int[][] cheese = new int[101][101];
	static int max;
	static int result;
	static int day;
	static int n;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int testcase=1;testcase<=tc;testcase++) {
			n = sc.nextInt();
			max = 0;
			result = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					cheese[i][j] = sc.nextInt();
					max = Math.max(max, cheese[i][j]);
				}
			}
			day = 0;
			for(int a=0;a<=max;a++) {
				boolean[][] check = new boolean[n+1][n+1];
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						if(cheese[i][j] == day) {
							cheese[i][j] = -1;
							check[i][j] = false;
						}
					}
				}
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						//System.out.print(cheese[i][j] + " ");
					}
					//System.out.println();
				}
				//System.out.println();
				bfs(cheese, check);
				day++;
			}
			System.out.println("#" + testcase + " " + result);
			
		}
		
	}
	
	public static void bfs(int[][] cheese, boolean[][] check) {
		int num = 0;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(cheese[i][j] != -1 && check[i][j] == false) {
					//System.out.println("한덩이 끝");
					Queue<Point> q = new LinkedList<Point>();
					q.add(new Point(i,j));
					//System.out.println(i + " " + j);
					check[i][j] = true;
					while(!q.isEmpty()) {
						int nx = q.peek().x;
						int ny = q.peek().y;
						q.poll();
						int x = 0;
						int y = 0;
						for(int d=0;d<4;d++) {
							x = nx + dx[d];
							y = ny + dy[d];
							if(x>=1 && x<=n && y>=1 && y<=n) {
								if(cheese[x][y] != -1 && check[x][y] == false) {
									//System.out.println(x + " " + y);
									q.add(new Point(x,y));
									check[x][y] = true;
								}
							}
							
						}
					}
					num++;
				}
			}
		}

		//System.out.println(num);
		result = Math.max(num, result);
		
		
	}

}
