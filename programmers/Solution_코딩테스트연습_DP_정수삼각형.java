package programmers;

import java.util.Arrays;

public class Solution_코딩테스트연습_DP_정수삼각형 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(triangle);
    }

    public static int[][] memo;

    public static int solution(int[][] triangle) {
        int n = triangle.length;
        memo = new int[n][n];

        memo[0][0] = triangle[0][0];
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j <= i; ++j) {
                calculate(i, j, triangle);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; ++i) {
            answer = Math.max(answer, memo[n - 1][i]);
        }
        return answer;
    }

    private static void calculate(int i, int j, int[][] triangle) {
        int r = i + 1;
        int c1 = j;
        int c2 = j + 1;
        int tmp1 = memo[i][j] + triangle[r][c1];
        int tmp2 = memo[i][j] + triangle[r][c2];

        memo[r][c1] = Math.max(memo[r][c1], tmp1);
        memo[r][c2] = Math.max(memo[r][c2], tmp2);
    }

    private static void print() {
        for (int i = 0; i < memo.length; ++i) {
            System.out.println(Arrays.toString(memo[i]));
        }
        System.out.println();
    }
}
