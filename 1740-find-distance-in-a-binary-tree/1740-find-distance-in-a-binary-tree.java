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
    public TreeNode getLCA(TreeNode node,int p,int q) {
        //base case
        if(node == null)return null;
        //if node is equal to pq or q
        if(node.val ==p || node.val ==q) return node;
        
        //left & right recursive call
        TreeNode leftFound = getLCA(node.left,p,q);
        TreeNode rightFound = getLCA(node.right,p,q);
        
        if(leftFound!=null && rightFound!=null) return node; // I AM THE LCA
        
        return leftFound!=null ? leftFound : rightFound;
    }
    
    public int findDist(TreeNode node,int val,int dist){
        //base Case
        if(node == null) return 0;
        if(node.val == val) return dist;
        
        //left and right recursive call
        int leftDist = findDist(node.left,val,dist+1);
        if(leftDist>0) return leftDist;
        int rightDist = findDist(node.right,val,dist+1);
        if(rightDist>0) return rightDist;
        
        return (leftDist + rightDist);
    }
    
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode LCA = getLCA(root,p,q);
        
        int distP = findDist(LCA,p,0);
        int distQ = findDist(LCA,q,0);
        //total distance between P and Q trhough our LCA.
        return distP+distQ;
    }
}