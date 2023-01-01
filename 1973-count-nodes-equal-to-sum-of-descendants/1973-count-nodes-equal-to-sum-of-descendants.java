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
    int totalN=0;
    public int equalToDescendants_01(TreeNode root) {
        if(root==null) return 0;
        
        int leftSum = equalToDescendants_01(root.left);
        int rightSum = equalToDescendants_01(root.right);
        
        if(leftSum+rightSum == root.val) totalN++;
        
        return leftSum+rightSum+root.val;
    }
    public int equalToDescendants(TreeNode root) {
        equalToDescendants_01(root);
        return totalN;
    }
}