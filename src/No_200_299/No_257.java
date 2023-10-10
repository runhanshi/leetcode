package No_200_299;

import java.util.ArrayList;
import java.util.List;

// No.257.Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths
public class No_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        traverse(root, new ArrayList<>(), res);
        return res;
    }

    private void traverse(TreeNode root, List<String> path, List<String> res){
        if (root == null ) {
            return;
        }

        if (root.left == null && root.right == null){
            path.add(root.val + "");
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val + "");
        traverse(root.left, res, path);
        traverse(root.right, res, path);
        path.remove(path.size() - 1);
    }

}
