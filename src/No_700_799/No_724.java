package No_700_799;
// No.724.Find Pivot Index
// https://leetcode.com/problems/find-pivot-index
public class No_724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < preSum.length; i++){
            int leftSum = preSum[i - 1] - preSum[0];
            int rightSum = preSum[n] - preSum[i];
            if (leftSum == rightSum) return i - 1;
        }

        // 或者
//        for (int i = 0; i < preSum.length - 1; i++){
//            int leftSum = preSum[i] - preSum[0];
//            int rightSum = preSum[n] - preSum[i + 1];
//            if (leftSum == rightSum) return i;
//        }
        return -1;
    }
}
