// SWExpertAcademy 2930. 힙

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static PriorityQueue<Integer> maxHeap;
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			n = sc.nextInt();
			
			maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
			
			sb.append("#").append(test_case).append(" ");
			
			for(int i=0; i<n; i++) {
				
				int cal = sc.nextInt();
								
				if(cal == 1) {
					int num = sc.nextInt();
					maxHeap.add(num);
				}
				else {
					if(!maxHeap.isEmpty())
						sb.append(maxHeap.poll()).append(" ");
					else
						sb.append("-1").append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
