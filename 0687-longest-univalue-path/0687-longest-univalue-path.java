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
    public int dfs(TreeNode node,int parVal) {
        if(node == null) return 0;
        
        int l = dfs(node.left,node.val);
        int r = dfs(node.right,node.val);
        
        if(node.left != null && node.val == node.left.val);
        
        if(node.right != null && node.val == node.right.val);
       
        
        ans = Math.max(ans,l+r);
        
        return node.val == parVal ? Math.max(l,r) +1 : 0; 
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,-1001);
        return ans;
    }
}