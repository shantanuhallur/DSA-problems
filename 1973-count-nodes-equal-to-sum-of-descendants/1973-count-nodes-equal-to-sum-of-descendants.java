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
    int totalN = 0;
    public int count(TreeNode node) {
        if(node==null) return 0;
        
        int leftSum = count(node.left);
        int rightSum = count(node.right);
        
        if(leftSum + rightSum == node.val) totalN++;
        
        return leftSum+rightSum+node.val;
    }
    public int equalToDescendants(TreeNode root) {
        count(root);
        return totalN;
    }
}