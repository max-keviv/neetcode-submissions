/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> bfs = new ArrayDeque<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        bfs.add(root);
        while(bfs.size()>0)
        {
            int size = bfs.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0)
            {
                TreeNode node = bfs.poll();
                level.add(Integer.valueOf(node.val));
                if(node.left != null) bfs.add(node.left);
                if(node.right != null) bfs.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
