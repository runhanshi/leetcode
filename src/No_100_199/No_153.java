package No_100_199;
// No.153.Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
public class No_153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // left == right: 相等
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (left == right) {
                return nums[left];
            }
            if (nums[mid] > nums[right]){
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[left];
    }
}
