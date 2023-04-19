package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_정렬_K번째수 {
    public static int[] solution(int[] array, int[][] commands) {

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < commands.length; ++i) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int num = commands[i][2] - 1;

            List<Integer> list = Arrays.stream(Arrays.copyOfRange(array, start, end))
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
            answer.add(list.get(num));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);
    }
}
