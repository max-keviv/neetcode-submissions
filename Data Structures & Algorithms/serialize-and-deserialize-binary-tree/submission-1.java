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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        if(root==null) return ans;
        Queue<TreeNode> levelOrder = new LinkedList<TreeNode>();
        levelOrder.add(root);
        while(levelOrder.size() > 0){
            TreeNode front = levelOrder.poll();
            if(front != null){
                levelOrder.add(front.left);
                levelOrder.add(front.right);
            }
            ans = ans + (front != null ? front.val + "#" : "#");
        }
        // System.out.println(ans);
        return ans;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] nodes = data.split("#");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> levelOrder = new LinkedList<TreeNode>();
        levelOrder.add(root);
        int ptr = 1;
        while(ptr < nodes.length)
        {
            TreeNode node = levelOrder.poll();

            if(nodes[ptr] != ""){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[ptr]));
                node.left = left;
                levelOrder.add(left);
            }
            ptr++;
            if(ptr < nodes.length && nodes[ptr] != ""){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[ptr]));
                node.right = right;
                levelOrder.add(right);
            }
            ptr++;
        }
        return root;
    }
}
// 1 2 3 # # 4 5
// 0 1 2 3 4 5 6
// 1
// 2 3
//   4 5