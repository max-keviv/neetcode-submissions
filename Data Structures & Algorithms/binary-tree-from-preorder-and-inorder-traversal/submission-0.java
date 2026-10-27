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
    int preIdx = 0;
    Map<Integer,Integer> index;
    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r)
    {
        if(l > r || preIdx >= preorder.length) return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);
        int mid = index.get(root.val);
        root.left = dfs(preorder,inorder,l,mid-1);
        root.right = dfs(preorder,inorder,mid+1,r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        index.put(inorder[i],i);
        
        return dfs(preorder,inorder,0,inorder.length);
    }
}
