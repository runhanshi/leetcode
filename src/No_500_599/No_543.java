package No_500_599;
// No.543.Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/
public class No_543 {
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return maxDepth;
    }

    private int maxDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDepth = Math.max(left + right, maxDepth);
        return 1 + Math.max(left, right);
    }

}
