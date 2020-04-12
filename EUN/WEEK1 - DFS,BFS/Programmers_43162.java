import java.util.ArrayList;

class Solution {
    
    static boolean[] check;
	static ArrayList<Integer>[] array;
	static int network;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        array = new ArrayList[n+1];
		check = new boolean[n+1];
		network = 0;
        
        for(int i=0;i<n;i++) {
			array[i+1] = new ArrayList<>();
			for(int j=0;j<n;j++) {
				if(computers[i][j] == 1) {
					array[i+1].add(j+1);
				}
			}
		}
        for(int i=1;i<=n;i++) {
			if(check[i] == false) {
				network++;
				dfs(i);
			}
		}
        answer = network;
        
        return answer;
    }
    
    public static void dfs(int num) {
		for(int i=0;i<array[num].size();i++) {
			int a = array[num].get(i);
			if(check[a] == false) {
				check[a] = true;
				dfs(a);
			}
		}
	}
    
}
