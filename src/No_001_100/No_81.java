package No_001_100;
// No.82.Search in Rotated Sorted Array II
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii
public class No_81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        while(left <= right){
            while(left < n -1 && nums[left] == nums[left + 1]) left++;
            while(right > 1 && nums[right] == nums[right - 1]) right--;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]){
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] >= nums[right]){
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
