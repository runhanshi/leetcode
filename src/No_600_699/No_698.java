package No_600_699;

import java.util.Arrays;

// No.698.Partition to K Equal Sum Subsets
// https://leetcode.com/problems/partition-to-k-equal-sum-subsets
public class No_698 {
    public boolean canPartitionKSubsets_FromNums(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        // 排序让剪枝更多，不然tle
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int target = sum / k;
        int[] buckets = new int[k];
        return backtrack_FromNums(nums, target, buckets, 0);
    }

    private boolean backtrack_FromNums(int[] nums, int target, int[] buckets, int index){
        if (index == nums.length){
            for (int bucket: buckets){
                if (bucket != target) return false;
            }
            return true;
        }
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] + nums[index] > target) continue;
            buckets[i] += nums[index];
            // Error Marker on 16/09/2023
            if (backtrack_FromNums(nums, target, buckets, index + 1)){
                return true;
            }
            buckets[i] -= nums[index];
        }
        return false;
    }

    public boolean canPartitionKSubsets_FromBuckets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum/ k;

        boolean[] used = new boolean[nums.length];
        return backtrack_FromBuckets(nums, k, 0, 0, target, used);
    }

    private boolean backtrack_FromBuckets(int[] nums, int k, int index, int bucket, int target, boolean[] used){
        if (k == 0) return true;
        if (bucket == target) return backtrack_FromBuckets(nums, k - 1, index, 0, target, used);
        // i = index: 剪枝
        for (int i = index; i < nums.length; i++){
            if (used[i]) continue;
            if (nums[i] + bucket > target) continue;
            used[i] = true;
            bucket += nums[i];
            // 是k不是k - 1，这个桶还不知道装没装好呢
            if (backtrack_FromBuckets(nums, k, i + 1, bucket, target, used)){
                return true;
            }
            used[i] = false;
            bucket -= nums[i];
        }
        return false;
    }

}
