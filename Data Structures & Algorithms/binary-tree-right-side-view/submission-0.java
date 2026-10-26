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
    int depth = -1;
    List<Integer> ans = new ArrayList<>();
    public void rightSideTraversal(TreeNode root, int curr_depth){
        if(root == null) return;
        if(curr_depth > depth){ ans.add(root.val); depth=curr_depth;}
        rightSideTraversal(root.right,curr_depth+1);
        rightSideTraversal(root.left,curr_depth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        rightSideTraversal(root,0);
        return ans;
    }
}
