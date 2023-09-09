package No_400_499;
// No.450.Delete Node in a BST
// https://leetcode.com/problems/delete-node-in-a-bst/
// 要删除的节点
// （1）没有子节点：直接删除
// （2）有一个子节点：子节点顶上
// （3）有两个子节点：找到左子树最大或右子树最小来替换
public class No_450 {
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key){
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root){
        while(root.left != null) root = root.left;
        return root;
    }

    // Time: O(H)
}
