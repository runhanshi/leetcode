package No_500_599;
// No.540.Single Element in a Sorted Array
// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class No_540 {
    // Binary Search
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0){
                if (nums[mid] == nums[mid + 1]){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    // 异或
    // 一个数和它本身异或为0，和0异或为本身
    public int singleNonDuplicate_2(int[] nums) {
        int res = 0;
        for (int num: nums){
            res ^= num;
        }
        return res;
    }
}
