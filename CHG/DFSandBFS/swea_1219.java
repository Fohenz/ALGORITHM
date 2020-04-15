import java.util.Scanner;
import java.util.ArrayList;

// SWExpertAcademy 1219. 길찾기

class Solution {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visit = new boolean[100];
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		
		T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			
			graph = new ArrayList[100];
			for(int i=0; i<100; i++) {
				graph[i] = new ArrayList<Integer>();
				visit[i] = false;
			}
			
			for(int i=0; i<n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph[a].add(b);
			}
			
			result = 0;
			DFS(0);
			
			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
	
	public static void DFS(int v) {
		visit[v] = true;
		if(v == 99) {
			result = 1;
			return;
		}
		
		for(int i=0; i<graph[v].size(); i++) {
			int next = graph[v].get(i);
			if(visit[next] == false) {
				DFS(next);
			}
		}
	}

}
