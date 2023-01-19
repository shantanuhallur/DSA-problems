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
    //gloabal  ans which hold LUP in whole tree
    int ans = 0;
    
    int getLUP(TreeNode node) {
        //Base Case
        if(node == null) return 0;
        //left and right recursive call of faith -> get me LUP throught MY L&R CHILD
        int l = getLUP(node.left);
        int r = getLUP(node.right);
        
        if(node.left != null && node.left.val == node.val) l += 1;
        else l = 0;
        
        if(node.right != null && node.right.val == node.val) r += 1;
        else r = 0;
        //Maximize ans's LUP
        ans = Math.max(ans,l+r);
        //return value will be as per our faith the max UVP THROUGH MY ROOT NODE
        return Math.max(l,r);
    }
    public int longestUnivaluePath(TreeNode root) {
        getLUP(root);
        return ans;
    }
}