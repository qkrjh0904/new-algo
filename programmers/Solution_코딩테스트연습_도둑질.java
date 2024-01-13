package programmers;

import java.util.Arrays;

public class Solution_코딩테스트연습_도둑질 {

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        solution(money);
    }

    public static int solution(int[] money) {
        int len = money.length;
        if (len == 3) {
            return Math.max(money[0], Math.max(money[1], money[2]));
        }

        int[] dp = new int[len];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }

        int[] dp2 = new int[len];
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);
        for (int i = 3; i < len; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp[len - 2], dp2[len - 1]);
    }

}
