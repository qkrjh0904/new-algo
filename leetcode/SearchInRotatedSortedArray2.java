package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SearchInRotatedSortedArray2 {
    public int search(int[] nums, int target) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(nums[i], i);
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        return -1;
    }
}
