package No_500_599;

import java.util.HashMap;
import java.util.Map;

// No.523.Continuous Subarray Sum
// https://leetcode.com/problems/continuous-subarray-sum/
public class No_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // (preSum[i] - preSum[j]) % k == 0
        // preSum[i] % k = preSum[j] % k
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for(int i = 0; i < preSum.length; i++){
            int val = preSum[i] % k;
            if (!valToIndex.containsKey(val)){
                valToIndex.put(val, i);
            }
        }

        for(int i = 0; i < preSum.length; i++){
            int need = preSum[i] % k;
            if (valToIndex.containsKey(need)){
                if (i - valToIndex.get(need) >= 2) return true;
            }
        }
        return false;
    }
}
