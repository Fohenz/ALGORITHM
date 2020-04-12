import java.util.Scanner;

public class Example5SwimmingPool {
    private static int minSum = 2147483647;

    public Example5SwimmingPool() {
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; ++test_case) {
            minSum = 2147483647;
            int[] price = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int[] usingPlan = new int[12];
            boolean[] checkMon = new boolean[12];

            for(int i = 0; i < 12; ++i) {
                usingPlan[i] = sc.nextInt();
            }

            backtracking(usingPlan, price, checkMon, 0, 0);
            System.out.println("#" + test_case + " " + minSum);
        }

    }

    public static int backtracking(int[] usingPlan, int[] price, boolean[] checkMon, int month, int sum) {
        if (month >= 12) {
            if (sum < minSum) {
                minSum = sum;
            }

            return minSum;
        } else {
            System.out.println("month : " + month + " / sum : " + sum + " / minSum : " + minSum);
            return backtracking(usingPlan, price, checkMon, month + 1, sum + usingPlan[month] * price[0]) + backtracking(usingPlan, price, checkMon, month + 1, sum + price[1]) + backtracking(usingPlan, price, checkMon, month + 3, sum + price[2]) + backtracking(usingPlan, price, checkMon, month + 12, sum + price[3]);
        }
    }
}