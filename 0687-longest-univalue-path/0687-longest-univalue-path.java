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
    int ans =0;
    public int getUVP(TreeNode node) {
        if(node == null) return 0;
        
        int l = getUVP(node.left);
        int r = getUVP(node.right);
        
        if(node.left !=null && node.left.val == node.val) l +=1;
        else l = 0;
        if(node.right !=null && node.right.val == node.val) r += 1;
        else r = 0;
        
        ans = Math.max(ans,l+r);
        
        return Math.max(l,r);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        getUVP(root);
        return ans;
    }
}