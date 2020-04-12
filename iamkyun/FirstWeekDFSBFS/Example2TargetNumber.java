public class Example2TargetNumber {
    int cnt;
    int tar;
    int ans = 0;
    int[][] array = new int[100][100];

    public Example2TargetNumber() {
    }

    public int solution(int[] numbers, int target) {
        int answer = false;
        this.cnt = numbers.length;
        this.tar = target;

        for(int i = 0; i < numbers.length; ++i) {
            this.array[i][0] = numbers[i];
            this.array[i][1] = numbers[i] * -1;
        }

        this.calculate(0, 0);
        int answer = this.ans;
        return answer;
    }

    void calculate(int row, int sum) {
        if (row == this.cnt) {
            if (sum == this.tar) {
                ++this.ans;
            }

        } else {
            for(int i = 0; i < 2; ++i) {
                this.calculate(row + 1, sum + this.array[row][i]);
            }

        }
    }
}
