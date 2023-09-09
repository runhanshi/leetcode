package No_400_499;
// No.486.Predict the Winner
// https://leetcode.com/problems/predict-the-winner/
public class No_486 {
    public boolean predictTheWinner(int[] nums){
        int n = nums.length;
        Pair[][] dp = new Pair[n][n];
        // initial
        for(int i = 0; i < n; i++){
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        // base case
        for(int i = 0; i < n; i++){
            dp[i][i].fir = nums[i];
            dp[i][i].sec = 0;
        }

        for (int i = n - 2; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                int left = nums[i] + dp[i + 1][j].sec;
                int right = nums[j] + dp[i][j - 1].sec;
                if (left > right){
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return (res.fir - res.sec) >= 0;
    }
}
