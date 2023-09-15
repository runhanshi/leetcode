package No_300_399;

import java.util.Arrays;

// No.300.Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/
public class No_300 {
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int res = 0;
        // dp[i]: 以nums[i]结尾的最长递增子序列
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
