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
    public String tree2str(TreeNode root) {
        String ans = "";
        //left recursive call
        if(root.left!=null) ans+= "(" + tree2str(root.left) + ")";
        //if left doesnt exist but right child does exist
        if(root.left==null && root.right != null) ans+= "()";
        //right recursive call
        if(root.right!=null) ans += "(" + tree2str(root.right) + ")";
        //append ans to my rootnode's val 
        return root.val + ans;
    }
}