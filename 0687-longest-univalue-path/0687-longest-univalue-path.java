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
    public int dfs(TreeNode node) {
        if(node == null) return 0;
        
        int l = dfs(node.left);
        int r = dfs(node.right);
        
        if(node.left != null && node.val == node.left.val) l+=1;
        else l=0;
        
        if(node.right != null && node.val == node.right.val) r+=1;
        else r = 0;
        
        ans = Math.max(ans,l+r);
        return Math.max(l,r); 
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
}