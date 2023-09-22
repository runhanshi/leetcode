package No_700_799;
// No.746.Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs
public class No_746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
