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
    boolean isBalanced = true;
    public int traversal(TreeNode root)
    {
        if(root == null) return 0;
        int left = traversal(root.left);
        int right = traversal(root.right);
        if(Math.abs(left-right)>1) isBalanced = false;
        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        traversal(root);
        return isBalanced;
    }
}
