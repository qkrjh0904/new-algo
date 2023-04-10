package programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_해시_폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return Math.min(nums.length / 2, set.size());
    }
}
