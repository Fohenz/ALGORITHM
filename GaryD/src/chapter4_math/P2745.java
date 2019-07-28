package chapter4_math;

import java.util.Scanner;

public class P2745 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] strs = sc.nextLine().split(" ");
		
		String str = strs[0];
		
		StringBuilder sb = new StringBuilder(str);
		int num = Integer.parseInt(strs[1]);
		int result = 0;
		
		for (int i = 0; i < sb.length(); i++) {

            char c = sb.charAt(i);

            if ('0' <= c && c <= '9') {
                result = result * num + (c - '0');
            } else {
                result = result * num + (c - 'A' + 10);
            }
		}
		
		System.out.println(result);
	}
}
