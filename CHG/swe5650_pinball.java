/******************************************
* SWExpertAcademy 5650번 문제 : 핀볼
******************************************/

import java.util.Scanner;

class swe5650_pinball {
	
	static int[][] pb = new int[102][102];
	static int N;
	static int point;
	static int[][] cd = {{0, -1, -1, 2, 3, -1}, {1, 3, 2, -1, -1, -1}, {2, 0, -1, -1, 1, -1}, {3, -1, 0, 1, -1, -1}}; // 0 or 1~5벽 만났을시 방향 전환
	static int x, y, d, score, nd, dd;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = sc.nextInt(); // N 입력
			
			// 웜홀 좌표 배열
			int[][] wh = {{-1,-1,-1,-1}, {-1,-1,-1,-1}, {-1,-1,-1,-1}, {-1,-1,-1,-1}, {-1,-1,-1,-1}};
			
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					// 맵 테두리 5번 벽으로 설정
					if(i == 0 || i == N+1 || j == 0 || j == N+1)
						pb[i][j] = 5;
					// 맵 입력 받음
					else {
						pb[i][j] = sc.nextInt();
						// 웜홀 좌표 설정
						if(pb[i][j] >= 6 && pb[i][j] <= 10) {
							if(wh[pb[i][j]-6][0] == -1 && wh[pb[i][j]-6][1] == -1) {
								wh[pb[i][j]-6][0] = i;
								wh[pb[i][j]-6][1] = j;
							}
							else {
								wh[pb[i][j]-6][2] = i;
								wh[pb[i][j]-6][3] = j;
							}
						}
					}
				}
			}
			
			// 최대점수 초기화
			point = 0;
			
			// 최대점수 계산 시작
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					
					if(pb[i][j] != 0) continue;
					
					for(int p=0; p<4; p++) {
						// 시작 좌표
						x = i;
						y = j;
						
						// 방향
						d = p;
						score = 0; // 현 점수
						
						while(true) {
							// 한 칸 이동
							if(d == 0) y += 1;
							else if(d == 1) y -= 1;
							else if(d == 2) x += 1;
							else if(d == 3) x -= 1;
							
							if(x == i && y == j) break;
							
							// 현재 칸 정보
							nd = pb[x][y];
							
							// 0 or 1, 2, 3, 4, 5번 벽을 만나면 -> 방향 전환
							if(nd >= 0 && nd <= 5) {
								dd = cd[d][nd];
								// 방향이 정 반대가 될 경우
								if(dd == -1) {
									score = 2 * score + 1;
									break;
								}
								// 방향이 바뀌었다면 점수 획득
								if(d != dd)
									score += 1;
								// 방향 변경
								d = dd;
							}
							// 웜홀을 만나면 -> 좌표 이동
							else if(nd >= 6 && nd <= 10) {
								if(wh[nd-6][0] == x && wh[nd-6][1] == y) {
									x = wh[nd-6][2];
									y = wh[nd-6][3];
								}
								else {
									x = wh[nd-6][0];
									y = wh[nd-6][1];
								}
							}
							// 블랙홀을 만나면 -> 바로 종료
							else
								break;
						}
						
						// 점수 갱신
						if(point < score) point = score;
					}
				}
			}
			System.out.println("#" + test_case + " " + point);
		}
	}
}
