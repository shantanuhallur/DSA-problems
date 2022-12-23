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
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    public void minDiffInBST_01(TreeNode node) {
        if(node==null) return;
        minDiffInBST_01(node.left);
        
        if(prev!=null){
            int diff = node.val-prev.val;
            minDiff = Math.min(minDiff,diff);
        }
        
        prev=node;
        minDiffInBST_01(node.right);
    }
    
    public int minDiffInBST(TreeNode root) {
        minDiffInBST_01(root);
        return minDiff;
    }
}