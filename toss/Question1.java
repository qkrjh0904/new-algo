package toss;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Question1 {

    public static void main(String[] args) {

//        solution("1451232125", 2);
        solution("12412415", 4);
    }

    public static int answer = 0;

    public static int solution(String s, int N) {
        for (int i = 0; i <= s.length() - N; ++i) {
            String substring = s.substring(i, i + N);
            check(substring, N);
        }

        answer = answer == 0 ? -1 : answer;
        System.out.println(answer);
        return answer;
    }

    private static void check(String substring, int N) {
        Set<Integer> set = Arrays.stream(substring.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        for (int i = 1; i <= N; ++i) {
            if (!set.contains(i)) {
                return;
            }
        }
        answer = Math.max(Integer.parseInt(substring), answer);
    }
}
