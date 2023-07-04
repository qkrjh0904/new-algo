package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution_코딩테스트연습_DP_N으로표현 {

    public static void main(String[] args) {
//        solution(5, 12);
        solution(1, 13);
//        solution(2, 11);
//        solution(5, 31168);
    }

    public static Map<Long, Integer> memo = new HashMap<>();
    public static int max = 0;

    public static int solution(int N, int number) {
        setMemo(N);
        if (memo.containsKey((long) number)) {
            System.out.println(memo.get((long) number));
            return memo.get((long) number);
        }

        while (true) {
            int now = memo.size();
            ArrayList<Long> keyList = new ArrayList<>(memo.keySet());
            for (Long a : keyList) {
                for (Long b : keyList) {
                    plus(a, b);
                    minus(a, b);
                    multiply(a, b);
                    divide(a, b);
                }
            }

            if (now == memo.size()) {
                break;
            }

            System.out.println(memo.size());
            System.out.println(memo);
            if (memo.containsKey((long) number)) {
                break;
            }
        }

        int answer = Objects.isNull(memo.get((long) number)) ? -1 : memo.get((long) number);
        System.out.println(answer);
        return answer;
    }


    private static void divide(Long a, Long b) {
        if (b == 0) return;
        long tmp = a / b;
        int tmpCnt = memo.get(a) + memo.get(b);
        if (tmp < 1 || tmpCnt > 8)
            return;

        memo.put(tmp, memo.containsKey(tmp) ? Math.min(memo.get(tmp), tmpCnt) : tmpCnt);
    }

    private static void multiply(Long a, Long b) {
        long tmp = a * b;
        int tmpCnt = memo.get(a) + memo.get(b);
        if (tmp < 1 || tmpCnt > 8)
            return;

        memo.put(tmp, memo.containsKey(tmp) ? Math.min(memo.get(tmp), tmpCnt) : tmpCnt);
    }

    private static void minus(Long a, Long b) {
        long tmp = a - b;
        int tmpCnt = memo.get(a) + memo.get(b);
        if (tmp < 1 || tmpCnt > 8)
            return;

        memo.put(tmp, memo.containsKey(tmp) ? Math.min(memo.get(tmp), tmpCnt) : tmpCnt);
    }

    private static void plus(Long a, Long b) {
        long tmp = a + b;
        int tmpCnt = memo.get(a) + memo.get(b);
        if (tmp < 1 || tmpCnt > 8)
            return;

        memo.put(tmp, memo.containsKey(tmp) ? Math.min(memo.get(tmp), tmpCnt) : tmpCnt);
    }

    private static void setMemo(int n) {
        String s = String.valueOf(n);
        String tmp = "";
        for (int i = 0; i < 8; ++i) {
            tmp += s;
            memo.put(Long.parseLong(tmp), i + 1);
        }
    }
}
