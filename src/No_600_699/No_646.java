package No_600_699;

import java.util.Arrays;
import java.util.Comparator;

// No.646.Maximum Length of Pair Chain
// https://leetcode.com/problems/maximum-length-of-pair-chain/
public class No_646 {
    public int findLongestChain_Greedy(int[][] pairs) {
        // 按结尾点从小到大排序
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int res = 0;
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++){
            if (cur < pairs[i][0]){
                res++;
                cur = pairs[i][1];
            }
        }
        return res;
    }
    // Time: O(nlongn)

    public int findLongestChain_DP(int[][] pairs){
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        // dp[i]: index为i的最长
        int[] dp = new int[n];
        int res = 0;

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            int curr = pairs[i][0];
            for (int j = 0; j < i; j++){
                if (pairs[j][1] < curr){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // Time: O(n ^ 2)
}
