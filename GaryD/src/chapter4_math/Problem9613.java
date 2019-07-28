package chapter4_math;

import java.util.Scanner;

public class Problem9613{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int result = 0;
		sc.nextLine();
		
		for (int i = 0; i < a; i++) {
			int n = sc.nextInt();
			int[] inputs = new int[n];
			
			result = 0;
			
			for (int j = 0; j < n; j++) inputs[j] = sc.nextInt();
			
			for (int j = 0; j < n-1; j++) {
				for (int j2 = j+1; j2 < n; j2++) {
					result += gcd(inputs[j], inputs[j2]);
				}
			}
			System.out.println(result);
		}
	}
	
	static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		}else {
			return gcd(y, x%y);
		}
	}
}
