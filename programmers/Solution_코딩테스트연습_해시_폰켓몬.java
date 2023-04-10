package programmers;

import java.util.HashSet;

public class Solution_코딩테스트연습_해시_폰켓몬 {
    public int solution(int[] nums) {

        int size = nums.length;

        // 가질 수 있는 최대개수
        int answer = size / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(answer, set.size());
    }
}
