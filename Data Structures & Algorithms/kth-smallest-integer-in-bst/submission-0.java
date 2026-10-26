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
    TreeNode ans;
    public int preOrderTraversal(TreeNode root, int rank, int k){
        if(root == null) return rank;
        int left = preOrderTraversal(root.left,rank,k);
        int pos = left + 1;
        if(pos == k) ans = root;
        int right = preOrderTraversal(root.right,pos,k);
        return right;
    }
    public int kthSmallest(TreeNode root, int k) {
        preOrderTraversal(root,0,k);
        return ans.val;
    }
}
