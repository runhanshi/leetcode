package No_600_699;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// No.652.Find Duplicate Subtrees
// https://leetcode.com/problems/find-duplicate-subtrees/
public class No_652 {
    List<TreeNode> res = new LinkedList<>();
    Map<String, Integer> memo = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root){
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
