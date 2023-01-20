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
    public int getDia(TreeNode node) {
        if(node == null) return -1;
        
        int l = getDia(node.left);
        int r = getDia(node.right);
        int diaTillMe = Math.max(l,r)+1;
        int maxPotentialdia = Math.max(l+r+2,diaTillMe);
        ans = Math.max(ans,maxPotentialdia);
        return diaTillMe;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        getDia(root);
        return ans;
    }
}