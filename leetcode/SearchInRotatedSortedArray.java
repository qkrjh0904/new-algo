package leetcode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int length = nums.length;
        if(length == 1){
            if(nums[0] == target){
                return 0;
            }
            return -1;
        }

        if(length == 2){
            if(nums[0] == target){
                return 0;
            }
            if(nums[1] == target){
                return 1;
            }
            return -1;
        }

        int start = 0;
        int end = length-1;
        int pivot = (start+end)/2;

        if(target == nums[pivot]){
            return pivot;
        }

        if((target < nums[pivot] && target >= nums[start]) ||
                (target > nums[pivot] && target >= nums[end])){
            return go(start, pivot-1, nums, target);
        }
        return go(pivot+1, end, nums, target);
    }

    public int go(int start, int end, int[] nums, int target){
        if(start==end && nums[start]==target){
            return start;
        }
        if(start>=end){
            return -1;
        }

        int pivot = (start+end)/2;
        if(target == nums[pivot]){
            return pivot;
        }

        if((target < nums[pivot] && target >= nums[start]) ||
                (target > nums[pivot] && target >= nums[end])){
            return go(start, pivot-1, nums, target);
        }
        return go(pivot+1, end, nums, target);
    }
}
