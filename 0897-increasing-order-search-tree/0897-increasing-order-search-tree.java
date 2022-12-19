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
    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = dummy;
    
    void increasingBST_01(TreeNode node) {
        if(node==null) return;
        
        increasingBST(node.left);
        
        prev.right = node;
        
        node.left = null;
        
        prev = node;
        
        increasingBST(node.right);
        
       
    }
    
    public TreeNode increasingBST(TreeNode root) {
        increasingBST_01(root);
        return dummy.right;
    }
}