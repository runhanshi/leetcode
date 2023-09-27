package No_100_199;
// No.154.Find Minimum in Rotated Sorted Array II
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
public class No_154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if (left == right) return nums[left];
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right--;
            }
        }
        // 这里走不到
        return nums[left];
    }
}
