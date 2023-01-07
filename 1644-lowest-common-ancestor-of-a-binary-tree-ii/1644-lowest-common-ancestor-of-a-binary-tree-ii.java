/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int totalFound=0;
    public TreeNode LCA(TreeNode node,int p, int q) {
        if(node == null) return null;
        TreeNode leftFound = LCA(node.left,p,q);
        TreeNode rightFound = LCA(node.right,p,q);
        
        if(node.val == p || node.val == q) {
            totalFound++;
            return node;
        }
        
        if(leftFound != null && rightFound != null) return node;
        
        return leftFound != null ? leftFound : rightFound;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = LCA(root,p.val,q.val);
        return totalFound == 2 ? ans : null;
    }
}