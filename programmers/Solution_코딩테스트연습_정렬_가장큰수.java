package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_정렬_가장큰수 {

    public static String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers).boxed()
                // 1이 10, 100보다 앞에와야함. 1000 이하니 3배로 문자열 더해줌
                .map(num -> (num.toString() + num.toString() + num.toString()))
                .sorted(Comparator.reverseOrder())
                .map(s -> s.substring(0, s.length() / 3))
                .collect(Collectors.toList());

        // 가장 큰 수가 0이라면 0으로 리턴
        if (list.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 10, 100};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {6, 10, 2};
        solution(numbers);
    }
}
