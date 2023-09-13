package No_500_599;

import java.util.HashMap;
import java.util.Map;

// No.560.Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/
public class No_560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int res = 0;
        for(int i = 1; i < n + 1; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int need = preSum[i] - k;
            if (count.containsKey(need)){
                res += count.get(need);
            }
            // 这个为什么放在后面，因为[1, 1, 1]
            if(!count.containsKey(preSum[i])){
                count.put(preSum[i], 1);
            } else {
                count.put(preSum[i], count.get(preSum[i]) + 1);
            }
        }
        return res;
    }
}
