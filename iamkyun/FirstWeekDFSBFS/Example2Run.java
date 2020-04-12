public class Example2Run {
    public Example2Run() {
    }

    public static void main(String[] args) {
        Example2TargetNumber example2TargetNumber = new Example2TargetNumber();
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        System.out.println(example2TargetNumber.solution(numbers, 3));
    }
}