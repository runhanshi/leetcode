package No_500_599;

import java.util.HashMap;
import java.util.Map;

// No.525.Contiguous Array
// https://leetcode.com/problems/contiguous-array/
public class No_525 {
    public int findMaxLength(int[] nums) {
        // 求和为 0 的最长子数组，相当于让你去 preSum 数组中找 i, j
        // 使得 preSum[i] - preSum[j] == 0，其中 i > j 且 i - j 要尽可能大。
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for(int i = 1; i < n + 1; i++){
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        Map<Integer, Integer> valToIndex = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n + 1; i++){
            if (!valToIndex.containsKey(preSum[i])){
                valToIndex.put(preSum[i], i);
            } else {
                res = Math.max(res, i - valToIndex.get(preSum[i]));
            }
        }
        return res;
    }
}
