package No_001_100;
// No.75.Sort Colors
// https://leetcode.com/problems/sort-colors
public class No_75 {
    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length;
        int cur = 0;
        while (cur < j){
            if (nums[cur] == 2){
                swap(nums, --j, cur);
            } else if (nums[cur] == 0){
                swap(nums, ++i, cur);
                cur++;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}
