package chapter1;

import java.util.Scanner;

public class pb10820 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String input;
		int upper;
		int lower;
		int num;
		int space;

		while (sc.hasNextLine()) {
			upper = 0;
			lower = 0;
			num = 0;
			space = 0;
			input = sc.nextLine();

			for (int i = 0; i < input.length(); i++) {
				int c = (int) input.charAt(i);
				if (c >= 97 && c <= 122) {
					lower++;
				} else if (c >= 65 && c <= 90) {
					upper++;
				} else if (c >= 48 && c <= 57) {
					num++;
				} else if (c == 32) {
					space++;
				}
			}

			System.out.println(lower + " " + upper + " " + num + " " + space);
		}

		sc.close();
	}

}