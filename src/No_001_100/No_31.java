package No_001_100;

import java.util.Arrays;

// No.31.Next Permutation
// https://leetcode.com/problems/next-permutation
public class No_31 {
    public void nextPermutation(int[] nums) {
        // step1: 从右往左找第一个降序排列的数字x
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if (i == -1) {
            Arrays.sort(nums);
            return;
        }

        // step2: 从右往左找第一个比x大的数字y
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) j--;

        // step3: 交换x和y
        swap(nums, i, j);

        // step4: 重新排列index_x + 1之后的数字
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i){
        int start = i;
        int end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
