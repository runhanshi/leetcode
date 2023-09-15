package No_600_699;

import java.util.*;

// No.662.Maximum Width of Binary Tree
// https://leetcode.com/problems/maximum-width-of-binary-tree/
public class No_662 {
    // bfs
    class Pair{
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree_bfs(TreeNode root){
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while(!q.isEmpty()){
            int sz = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < sz; i++){
                Pair cur = q.poll();
                TreeNode curNode = cur.node;
                int curId = cur.id;
                if (i == 0){
                    start = curId;
                }
                if (i == sz - 1){
                    end = curId;
                }
                if (curNode.left != null) {
                    q.offer(new Pair(curNode, 2 * curId));
                }
                if (curNode.right != null) {
                    q.offer(new Pair(curNode, 2 * curId + 1));
                }
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }

    // dfs
    public int widthOfBinaryTree_dfs(TreeNode root){
        if (root == null) return 0;
        traverse(root, 1, 1);
        return maxWidthDfs;
    }

    int maxWidthDfs = 1;
    // 最左侧编号
    List<Integer> firstId = new ArrayList<>();

    private void traverse(TreeNode root, int id, int depth){
        if (root == null) return;
        if (firstId.size() < depth - 1){
            firstId.add(id);
        } else {
            maxWidthDfs = Math.max(maxWidthDfs, id - firstId.get(depth - 1) + 1);
        }
        traverse(root.left, id * 2, depth + 1);
        traverse(root.right, id * 2 + 1, depth + 1);
    }


}
