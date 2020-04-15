// 프로그래머스. 더 맵게

import java.util.PriorityQueue;
class Solution {
    static PriorityQueue<Integer> queue;
    public int solution(int[] scoville, int K) {
        int answer = 0;
		
		queue = new PriorityQueue<Integer>();
		
		for(int i=0; i<scoville.length; i++) {
			queue.add(scoville[i]);
		}
		
		int a = 0;
		int b = 0;
		boolean bigger = false;
		
		for(int i=0; i<scoville.length; i++) {
			a = queue.poll();
			
			if(a >= K) {
				bigger = true;
				break;
			}
			
			if(queue.isEmpty()) break;
			else {
				b = queue.poll();
				queue.add(a + (2*b));
				answer++;
			}
		}
		
		if(bigger == false) answer = -1;
		
		return answer;
    }
}
