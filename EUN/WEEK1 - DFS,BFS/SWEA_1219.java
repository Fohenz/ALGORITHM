package swExpertAcademy;

import java.util.Scanner;

public class problem1219 {
	
	static int[] array1 = new int[100];
	static int[] array2 = new int[100];
	static boolean[] array3 = new boolean[100];
	static boolean result;
	static boolean[] check = new boolean[100];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			for(int i=0;i<100;i++) {
				array1[i] = 1111;
				array2[i] = 1111;
				array3[i] = false;
				check[i] = false;
			}
			int testcase = sc.nextInt();
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(array3[a] == false) {
					array1[a] = b;
					array3[a] = true;
				} else {
					array2[a] = b;
				}
			}
			result = false;
			dfs(0);
			if(result) {
				System.out.println("#" + testcase + " 1");
			} else {
				System.out.println("#" + testcase + " 0");
			}
			if(testcase == 10) {
				break;
			}
		}

	}
	
	public static void dfs(int now) {
		//System.out.println(now);
		if(now == 99) {
			result = true;
			//System.out.println();
			return;
		}
		if(array1[now] != 1111 && check[array1[now]] == false) {
			check[array1[now]] = true;
			dfs(array1[now]);
		}
		if(array2[now] != 1111 && check[array2[now]] == false) {
			check[array2[now]] = true;
			dfs(array2[now]);
		}
		//System.out.println();
		return;
	}

}
