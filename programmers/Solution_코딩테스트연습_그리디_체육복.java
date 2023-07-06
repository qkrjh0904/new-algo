package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_그리디_체육복 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        solution(n, lost, reserve);
    }

    public static Set<Integer> lostSet;
    public static Set<Integer> reserveSet;

    public static int solution(int n, int[] lost, int[] reserve) {
        setting(lost, reserve);
        for (Integer num : reserveSet) {
            if (lostSet.contains(num - 1)) {
                lostSet.remove(num - 1);
                continue;
            }
            if (lostSet.contains(num + 1)) {
                lostSet.remove(num + 1);
            }
        }

        int answer = n - lostSet.size();
        System.out.println(answer);
        return answer;
    }

    private static void setting(int[] lost, int[] reserve) {
        lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());

        Set<Integer> duplicate = new HashSet<>();
        for (Integer num : lostSet) {
            if (reserveSet.contains(num))
                duplicate.add(num);
        }

        lostSet.removeAll(duplicate);
        reserveSet.removeAll(duplicate);
    }
}
