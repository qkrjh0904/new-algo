package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_정렬_HIndex {

    public static int solution(int[] citations) {

        List<Integer> list = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int answer = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            int min = Math.min(i + 1, list.get(i));
            answer = Math.max(answer, min);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        solution(citations);
    }
}
