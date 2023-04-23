package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_코딩테스트연습_완전탐색_모의고사 {

    public static int[] solution(int[] answers) {

        List<Integer> man1Answers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        List<Integer> man2Answers = List.of(2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> man3Answers = List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        int man1 = 0;
        int man2 = 0;
        int man3 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < answers.length; ++i) {
            int index = i % 40;
            int answer = answers[i];
            man1 = answer == man1Answers.get(index) ? man1 + 1 : man1;
            man2 = answer == man2Answers.get(index) ? man2 + 1 : man2;
            man3 = answer == man3Answers.get(index) ? man3 + 1 : man3;
        }

        int max = Math.max(man1, Math.max(man2, man3));
        if (man1 == max) result.add(1);
        if (man2 == max) result.add(2);
        if (man3 == max) result.add(3);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 2};
        solution(answers);
    }

}
