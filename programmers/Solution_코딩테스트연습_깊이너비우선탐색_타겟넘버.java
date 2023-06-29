package programmers;

public class Solution_코딩테스트연습_깊이너비우선탐색_타겟넘버 {

    public static int answer = 0;

    public static int solution(int[] numbers, int target) {
        go(0, numbers, target, 0);
        return answer;
    }

    private static void go(int index, int[] numbers, int target, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        int number = numbers[index];
        go(index + 1, numbers, target, sum + number);
        go(index + 1, numbers, target, sum + (number * -1));

    }

    public static void main(String[] args) {
//        int[] numbers = {1, 1, 1, 1, 1};
//        int target = 3;
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        solution(numbers, target);
    }

}
