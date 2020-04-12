import java.util.Scanner;

public class Example4FindRoute {
    private static int result = 0;

    public Example4FindRoute() {
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; ++test_case) {
            result = 0;
            int lineCnt = sc.nextInt();
            int[][] array = new int[100][100];
            boolean[] isNotFirst = new boolean[100];

            for(int i = 0; i < lineCnt; ++i) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                array[x][y] = 1;
                array[y][x] = 1;
            }

            dfs(array, isNotFirst, 0);
            System.out.println("#" + test_case + " " + result);
        }

    }

    public static void dfs(int[][] array, boolean[] isNotFirst, int start) {
        isNotFirst[start] = true;
        if (start == 99) {
            result = 1;
        } else {
            for(int i = 0; i < array.length; ++i) {
                if (array[start][i] == 1 && !isNotFirst[i]) {
                    dfs(array, isNotFirst, i);
                }
            }

        }
    }
}