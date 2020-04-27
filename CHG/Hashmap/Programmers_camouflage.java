import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			}
			else {
				map.put(clothes[i][1], 2);
			}
		}
		
		for(String k : map.keySet()) {
			answer *= map.get(k);
		}
		
		return answer-1;
    }
}
