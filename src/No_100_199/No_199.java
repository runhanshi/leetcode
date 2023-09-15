package No_100_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// No.199.Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/
public class No_199 {
    // dfs
    List<Integer> resDfs = new ArrayList<>();
    int depth = 0;
    public List<Integer> rightSideView_dfs(TreeNode root){
        traverse(root);
        return resDfs;
    }

    private void traverse(TreeNode root){
        if (root == null) return;
        depth++;
        if (resDfs.size() < depth){
            resDfs.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth--;
    }

    // bfs
    public List<Integer> rightSideView_bfs(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            TreeNode last = q.peek();
            for (int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null){
                    q.offer(cur.left);
                }
            }
            res.add(last.val);
        }
        return res;
    }
}
