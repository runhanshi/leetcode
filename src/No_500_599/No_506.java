package No_500_599;

import java.util.Arrays;

// No.506.Relative Ranks
// https://leetcode.com/problems/relative-ranks/
public class No_506 {
    public String[] findRelativeRanks(int[] score){
        int n = score.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++){
            idx[i] = i;
        }

        Arrays.sort(idx, (i1, i2) -> score[i2] - score[i1]);
        String[] ans = new String[n];
        String[] tops = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < n; i++){
            // i: 前几
            // idx[i]: 前几在score离的index
            ans[idx[i]] =  i < 3 ?  tops[i] : String.valueOf(i + 1);
        }
        return ans;
    }
}
