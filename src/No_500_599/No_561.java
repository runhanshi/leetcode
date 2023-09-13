package No_500_599;

import java.util.Arrays;

// No.561.Array Partition
// https://leetcode.com/problems/array-partition/
public class No_561 {
    // 先排序，然后相邻两个元素组合，取最小值，加起来
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2){
            res += nums[i];
        }
        return res;
    }
}
