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
    public TreeNode getLCA(TreeNode node, int p, int q) {
        if(node== null) return null;
        if(node.val==p || node.val == q) return node;
        
        TreeNode left = getLCA(node.left,p,q);
        TreeNode right = getLCA(node.right,p,q);
        
        if(left!=null && right!=null) return node;
        
        return left == null ? right : left;
    }
    
    int getDistanceToNode(TreeNode node,int val,int dist) {
        if(node == null) return 0;
        if(node.val == val) return dist;
        
        int leftDist = getDistanceToNode(node.left,val,dist+1);
        if(leftDist>0) return leftDist;
        int rightDist = getDistanceToNode(node.right,val,dist+1);
        if(rightDist>0) return rightDist;
        
        return leftDist+rightDist;
    }
    
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode LCA = getLCA(root,p,q);
        int leftD = getDistanceToNode(LCA,p,0);
        int rightD = getDistanceToNode(LCA,q,0);
        return leftD+rightD;
    }
}