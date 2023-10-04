package No_001_100;
// No.41.First Missing Positive
// https://leetcode.com/problems/first-missing-positive
public class No_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++){
            if (i + 1 != nums[i]){
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
