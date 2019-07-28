package chapter4_math;

import java.util.Scanner;

public class Problem1978 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;

        while (n-- > 0) {
            if (prime(sc.nextInt())) {
                ans += 1;
            }
        }

        System.out.println(ans);
	}

	static boolean prime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
