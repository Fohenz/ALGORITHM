package chapter4_math;

import java.util.Scanner;

public class Problem11005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		StringBuilder ans = new StringBuilder();
		
		while(a > 0) {
			int r = a % b;
			
			if(r < 10) {
				ans.append((char)(r + '0'));
			}else {
				ans.append((char)(r - 10 + 'A'));
			}
			
			a /= b;
		}
		System.out.println(ans.toString());
	}
}
