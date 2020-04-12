public class Example3Network {
    boolean[] isNotFirst;
    int[][] array;

    public Example3Network() {
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.array = computers;
        this.isNotFirst = new boolean[n];

        for(int i = 0; i < this.isNotFirst.length; ++i) {
            if (!this.isNotFirst[i]) {
                ++answer;
                this.dfs(i);
            }
        }

        return answer;
    }

    public void dfs(int node) {
        this.isNotFirst[node] = true;

        for(int i = 0; i < this.array.length; ++i) {
            if (this.array[node][i] == 1 && !this.isNotFirst[i]) {
                this.dfs(i);
            }
        }

    }
}