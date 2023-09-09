package No_800_899;

// No.877.Stone Game
// https://leetcode.com/problems/stone-game/
public class No_877 {
    public boolean stoneGame(int[] piles){
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                dp[i][j] = new Pair(0, 0);
            }
        }
        for (int i = 0; i < n; i++){
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        for (int i = n - 2; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left < right){
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
