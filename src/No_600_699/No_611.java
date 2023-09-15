package No_600_699;

import java.util.Arrays;

// No.611.Valid Triangle Number
// https://leetcode.com/problems/valid-triangle-number/
public class No_611 {
    public int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; i++){
            int right = i - 1;
            int left = 0;
            while(left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
