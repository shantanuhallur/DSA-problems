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
    
    public int getMaxPathSum(TreeNode node) {
        //Base Case
        if(node == null) return 0;
        //left and right Recursive calls which will return maxPathSum through respective child nodes
        int l = getMaxPathSum(node.left);
        int r = getMaxPathSum(node.right);
        int maxPathTillMyNode = Math.max(Math.max(l,r) + node.val,node.val);
        int maxPathForMyNode = Math.max(maxPathTillMyNode,l+r+node.val);
        //maximize if this is the global maximum path sum;
        ans = Math.max(ans,maxPathForMyNode);
        return maxPathTillMyNode;
    }
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return ans;
    }
}