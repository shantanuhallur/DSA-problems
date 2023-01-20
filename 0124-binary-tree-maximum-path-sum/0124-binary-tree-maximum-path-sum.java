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
    public int getPathSum(TreeNode node) {
        if(node ==  null) return -1001;
        //PS passing through my left and right child
        int l = getPathSum(node.left); 
        int r = getPathSum(node.right);
        int myMaxsum = Math.max(Math.max(l+node.val,r+node.val),Math.max(node.val,l+r+node.val));
        ans = Math.max(ans,myMaxsum);
        //MaxSum Path passing through my node;
        return Math.max(node.val,Math.max(l,r) + node.val);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        getPathSum(root);
        return ans;
    }
}