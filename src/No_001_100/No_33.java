package No_001_100;
// No.33.Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array
public class No_33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[right]){
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]){
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
