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
    TreeNode prev = null;
    int currSum = 0;
    void bstToGst_01(TreeNode node) {
        if(node == null) return;
        
        bstToGst_01(node.right);
        
        currSum+= node.val;
        node.val = currSum;
        
        prev = node;
        bstToGst_01(node.left);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        bstToGst_01(root);
        return root;
    }
}