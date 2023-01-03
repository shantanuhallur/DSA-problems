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
    int ans = 0;
    public int distribute(TreeNode node) {
        if(node==null) return 0;
        
        int leftExDef = distribute(node.left);
        int rightExDef = distribute(node.right);
        ans+=  Math.abs(leftExDef) + Math.abs(rightExDef);
        return (leftExDef +rightExDef + node.val-1); 
        
    }
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }
}