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
    int ans = -1001;
    int getPathSum(TreeNode node) {
        if(node == null) return 0;
        
        int l = getPathSum(node.left);
        int r = getPathSum(node.right);
        
        int maxTillFromChildsToMe = Math.max(Math.max(l,r) + node.val,node.val);
        int potentialMaxThroughMe = Math.max(maxTillFromChildsToMe,l+r+node.val);
        ans = Math.max(ans,potentialMaxThroughMe);
        
        return maxTillFromChildsToMe;
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        getPathSum(root);
        return ans;
    }
}