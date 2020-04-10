class Solution {

    static boolean[] visit;
    
    public static int Solution(int n, int[][] computers) {
		int answer = 1;
		
		visit = new boolean[n];
		for(int i=0; i<n; i++) visit[i] = false;
		
		int start = 0;
		while(true) {
			System.out.println("start : " + start);
			DFS(n, computers, start);
			start++;
			for(int i=start; i<n; i++) {
				if(visit[i] == false) {
					answer++;
					start = i;
					break;
				}
			}
			if(start >= n) break;
		}
		
		//for(int i=0; i<n; i++) System.out.print(visit[i] + " ");
		
		return answer;
	}
	
	public static void DFS(int n, int[][] computers, int v) {
		visit[v] = true;
		for(int i=0; i<n; i++) {
			if(v != i && visit[i] == false && computers[v][i] == 1) {
				DFS(n, computers, i);
			}
		}
	}
}
