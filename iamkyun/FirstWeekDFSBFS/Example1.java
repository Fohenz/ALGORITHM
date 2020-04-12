import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Example1 {
    private static int n;
    private static int m;
    private static boolean[] isNotFirst;
    private static int[][] array;
    private static Queue<Integer> queue = new ArrayDeque();
    private static String resultDfs = "";
    private static String resultBfs = "";

    public Example1() {
    }

    public static void main(String[] args) {
        execution();
    }

    public static void execution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int startN = sc.nextInt();
        array = new int[n + 1][n + 1];
        isNotFirst = new boolean[n + 1];

        for(int i = 0; i < m; ++i) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            array[n1][n2] = 1;
            array[n2][n1] = 1;
        }

        dfs(startN);
        isNotFirst = new boolean[n + 1];
        bfs(startN);
        System.out.println(resultDfs.trim());
        System.out.println(resultBfs.trim());
    }

    public static void dfs(int node) {
        isNotFirst[node] = true;
        resultDfs = resultDfs + node + " ";

        for(int i = 1; i <= n; ++i) {
            if (array[node][i] == 1 && !isNotFirst[i]) {
                dfs(i);
            }
        }

    }

    public static void bfs(int node) {
        isNotFirst[node] = true;
        queue.add(node);

        while(!queue.isEmpty()) {
            int a = (Integer)queue.poll();
            resultBfs = resultBfs + a + " ";

            for(int i = 1; i <= n; ++i) {
                if (array[a][i] == 1 && !isNotFirst[i]) {
                    isNotFirst[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
