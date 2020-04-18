import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		
		PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int num = 0;
		for(int i=0; i<operations.length; i++) {
			num = Integer.parseInt(operations[i].substring(2));
			if("I".equals(String.valueOf(operations[i].charAt(0)))) {
				if(max_heap.isEmpty()) min_heap.add(num);
				else if(min_heap.isEmpty()) max_heap.add(num);
			}
			else {
				// 최대값 뽑기
				if(num == 1) {
					// 최대 힙 비어있으면 -> 최소 힙 내용을 최대 힙으로 이동
					if(max_heap.isEmpty()) {
						while(!min_heap.isEmpty()) {
							max_heap.add(min_heap.poll());
						}
					}
					max_heap.poll();
				}
				// 최솟값 뽑기
				else if(num == -1) {
					// 최소 힙 비어있으면 -> 최대 힙 내용을 최소 힙으로 이동
					if(min_heap.isEmpty()) {
						while(!max_heap.isEmpty()) {
							min_heap.add(max_heap.poll());
						}
					}
					min_heap.poll();
				}
			}
		}
		
		if(max_heap.isEmpty())
			while(!min_heap.isEmpty())
				arr.add(min_heap.poll());
		else
			while(!max_heap.isEmpty())
				arr.add(max_heap.poll());
		
		if(arr.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		}
		else if(arr.size() == 1) {
			answer[0] = arr.get(0);
			answer[1] = arr.get(0);
		}
		else {
			answer[0] = arr.get(arr.size()-1);
			answer[1] = arr.get(0);
		}
		
		return answer;
    }
}
