import java.util.Scanner;

public class Example6CheeseThief {
    private static int maxCnt = 0;

    public Example6CheeseThief() {
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; ++test_case) {
            maxCnt = 0;
            int len = sc.nextInt();
            int[][] cheeseNum = new int[len][len];
            int[][] cheeseStatus = new int[len][len];
            boolean[][] check = new boolean[len][len];

            for(int i = 0; i < len; ++i) {
                for(int j = 0; j < len; ++j) {
                    cheeseNum[i][j] = sc.nextInt();
                }
            }

            fun(cheeseNum, cheeseStatus, check, 1, 0);
            System.out.println("#" + test_case + " " + maxCnt);
        }

    }

    public static void fun(int[][] cheeseNum, int[][] cheeseStatus, boolean[][] check, int day, int max) {
        System.out.println("day : " + day);
        if (day > 100) {
            if (max > maxCnt) {
                maxCnt = max;
            }

        } else {
            int i;
            int j;
            for(i = 0; i < cheeseNum.length; ++i) {
                for(j = 0; j < cheeseNum.length; ++j) {
                    if (cheeseNum[i][j] == day) {
                        cheeseStatus[i][j] = 1;
                    }
                }
            }

            for(i = 0; i < cheeseStatus.length; ++i) {
                for(j = 0; j < cheeseStatus.length; ++j) {
                    if (!check[i][j] && cheeseStatus[i][j] != 1) {
                        ++max;
                        if (max > maxCnt) {
                            maxCnt = max;
                        }

                        System.out.println("max : " + max);
                        dfs(cheeseStatus, check, i, j);
                    }
                }
            }

            System.out.println("================================");
            fun(cheeseNum, cheeseStatus, new boolean[cheeseNum.length][cheeseNum.length], day + 1, 0);
        }
    }

    public static void dfs(int[][] cheeseStatus, boolean[][] check, int i, int j) {
        System.out.println("cheeseStatus[" + i + "][" + j + "] : " + cheeseStatus[i][j]);
        if (cheeseStatus[i][j] == 0 && !check[i][j]) {
            check[i][j] = true;
            if (i != 0) {
                dfs(cheeseStatus, check, i - 1, j);
            }

            if (j != 0) {
                dfs(cheeseStatus, check, i, j - 1);
            }

            if (i != cheeseStatus.length - 1) {
                dfs(cheeseStatus, check, i + 1, j);
            }

            if (j != cheeseStatus.length - 1) {
                dfs(cheeseStatus, check, i, j + 1);
            }
        } else if (cheeseStatus[i][j] == 1) {
            check[i][j] = true;
        }

    }
}