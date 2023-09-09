package No_400_499;

import java.util.HashMap;

// No.494.Target Sum
// https://leetcode.com/problems/target-sum/
public class No_494 {
    public int findTargetSumWays(int[] nums, int target){
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }

    HashMap<String,Integer> memo = new HashMap<>();
    private int dp(int[] nums, int i, int remain){
        if (i == nums.length){
            if (remain == 0) return 1;
            return 0;
        }
        String key = i + "," + remain;
        if (memo.containsKey(key)) return memo.get(key);
        int result = dp(nums, i + 1, remain - nums[i]) +
                dp(nums, i + 1, remain + nums[i]);
        memo.put(key, result);
        return result;
    }
}
