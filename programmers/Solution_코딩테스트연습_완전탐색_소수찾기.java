package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_완전탐색_소수찾기 {

    public static HashSet<Integer> set = new HashSet<>();

    public static int solution(String numbers) {
        List<String> list = Arrays.stream(numbers.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        boolean[] visit = new boolean[numbers.length()];
        Arrays.fill(visit, false);

        if (list.get(0).equals("0")) {
            return 0;
        }

        for (int limit = 1; limit <= list.size(); ++limit) {
            dfs(list, limit, "", visit);
        }

        return set.size();
    }

    private static void dfs(List<String> list, int limit, String now, boolean[] visit) {
        if (now.length() == limit) {
            int num = Integer.parseInt(now);
            if (isPrimeNumber(num)) {
                set.add(num);
            }
            return;
        }

        for (int i = 0; i < list.size(); ++i) {
            if (!visit[i]) {
                visit[i] = true;
                now += list.get(i);
                dfs(list, limit, now, visit);
                visit[i] = false;
                now = now.substring(0, now.length() - 1);
            }
        }
    }

    private static Boolean isPrimeNumber(Integer number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String numbers = "110";
        solution(numbers);
    }

}
