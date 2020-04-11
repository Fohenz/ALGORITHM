import java.util.Scanner;

public class Solution {
	
	static int day, month, bungi, year, min_value;
	static int[] plan;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			// 이용권 가격들
			day = sc.nextInt();
			month = sc.nextInt();
			bungi = sc.nextInt();
			year = sc.nextInt();
			
			// 12개월 이용 계획
			plan = new int[12];
			for(int i=0; i<12; i++) {
				int p = sc.nextInt();
				plan[i] = p;
			}
			
			min_value = 99999999;
			
			DFS(0, 0, 0, 0);
			DFS(0, 0, 1, 0);
			DFS(0, 0, 2, 0);
			DFS(0, 0, 3, 0);
			
			System.out.println("#" + test_case + " " + min_value);
		}
	}
	
	public static void DFS(int m, int d, int t, int value) {
		int mm = m; // 현재 월
		int dd = d; // 수강 일 합계
		
		// 현재 월에 수강 안하면
		if(plan[mm] == 0 || dd >= plan[mm]) {
			mm++;
			dd = 0;
		}
		// 현재 월에 수강하면
		else {
			// 1일권 끊을때
			if (t == 0) {
				value += day;
				dd++;
			} 
			// 1달권 끊을때
			else if (t == 1) {
				value += month;
				mm++;
				dd = 0;
			} 
			// 3달권 끊을때
			else if (t == 2) {
				value += bungi;
				if (mm >= 9) {
					mm = 12;
				} 
				else {
					mm += 3;
					dd = 0;
				}
			} 
			// 1년권 끊을때
			else {
				value += year;
				mm = 12;
			}
		}
		
		// 13월 이상일 경우 : 끝
		if(mm >= 12) {
			if(min_value > value) min_value = value;
			return;
		}
		
		if(dd > 0)
			DFS(mm, dd, 0, value);
		else {
			DFS(mm, dd, 0, value);
			DFS(mm, dd, 1, value);
			DFS(mm, dd, 2, value);
			DFS(mm, dd, 3, value);
		}
	}
}
