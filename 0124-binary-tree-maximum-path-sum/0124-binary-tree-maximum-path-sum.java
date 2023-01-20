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
        int myMaxStopsum = Math.max(node.val , Math.max(l,r)+node.val);
        int myMaxSum = Math.max(myMaxStopsum,l+r+node.val);
        ans = Math.max(ans,myMaxSum);
        //MaxSum Path passing through my node;
        return myMaxStopsum;
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        getPathSum(root);
        return ans;
    }
}