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
    public int height(TreeNode node) {
        if(node==null) return 0;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight,rightHeight) +1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        
        int leftSubtreeHeight = height(root.left);
        int rightSubtreeHeight = height(root.right);
        
        if(leftSubtreeHeight == rightSubtreeHeight) return root;
        
        else if(leftSubtreeHeight > rightSubtreeHeight) 
            return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }
}