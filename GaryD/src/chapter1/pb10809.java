package chapter1;

import java.util.Scanner;

public class pb10809 {
	public static void main(String args[]) {
		String s;
		int arr[] = new int[26];
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		char[] a = s.toCharArray();

		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}

		for (int j = 0; j < a.length; j++) {
			int tmp = a[j] - 97;
			if (arr[tmp] == -1)
				arr[tmp] = j;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
