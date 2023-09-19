package No_400_499;

import java.util.HashMap;
import java.util.Map;

// No.437.Path Sum II
// https://leetcode.com/problems/path-sum-iii
public class No_437 {
    Map<Long, Integer> preSumCount = new HashMap<>();
    long target;
    int res = 0;

    public int pathSum(TreeNode root, int target) {
        if (root == null) return 0;
        this.target = target;
        this.preSumCount.put(0L, 1);
        traverse(root, 0L);
        return res;
    }

    private void traverse(TreeNode root, long currentPreSum){
        if (root == null) return;
        currentPreSum += root.val;
        res += preSumCount.getOrDefault(currentPreSum - this.target, 0);
        preSumCount.put(currentPreSum, preSumCount.getOrDefault(currentPreSum, 0) + 1);

        traverse(root.left, currentPreSum);
        traverse(root.right, currentPreSum);
        preSumCount.put(currentPreSum, preSumCount.get(currentPreSum) - 1);
    }
}
