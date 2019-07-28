package chapter4_math;

import java.util.Scanner;

public class Problem2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
        int g = gcd(a, b);
        int l = a * b / g;

		System.out.println(g);
		System.out.println(l);
	}
	
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
}
