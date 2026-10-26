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
    int ans = 0;
    public int traversal(TreeNode root, int mx)
    {
        if(root == null) return 0;

        return (root.val >= mx ? 1 : 0 ) + traversal(root.left,Math.max(root.val,mx)) + traversal(root.right,Math.max(root.val,mx));
    }
    public int goodNodes(TreeNode root) {
        return traversal(root,-1000);
    }
}
