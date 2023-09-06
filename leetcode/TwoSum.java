package leetcode;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int x = nums[i];
                int y = nums[j];

                if (x + y == target) {
                    int[] answer = {i, j};
                    return answer;
                }
            }
        }
        return null;
    }
}
