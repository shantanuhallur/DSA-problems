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
    public TreeNode LCA(TreeNode node,int p,int q) {
        if(node == null) return null;
        if(node.val ==p || node.val ==q) return node;
        
        TreeNode left = LCA(node.left,p,q);
        TreeNode right = LCA(node.right,p,q);
        
        if(left!=null && right!=null) return node;
        
        return left != null ? left : right;
    }
    int getDist(TreeNode node,int val, int dist) {
        if(node == null) return 0;
        if(node.val == val) return dist;
        
        int left = getDist(node.left,val,dist+1);
        if(left>0) return left;
        int right = getDist(node.right,val,dist+1);
        if(right>0) return right;
        
        return left+right;
    }
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode LCA = LCA(root,p,q);
        int distP = getDist(LCA,p,0);
        int distQ = getDist(LCA,q,0);
        
        return distP+distQ;
    }
}