package chapter4_math;

import java.util.Scanner;

public class Problem1934 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
			
		for (int i = 0; i < a; i++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			int g = gcd(b,c);
			System.out.println(b*c / g);
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
