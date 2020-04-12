public class Example3Run {
    public Example3Run() {
    }

    public static void main(String[] args) {
        Example3Network example3Network = new Example3Network();
        int[][] numbers = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(example3Network.solution(3, numbers));
    }
}