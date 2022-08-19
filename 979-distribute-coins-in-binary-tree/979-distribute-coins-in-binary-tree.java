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
    int numMoves;
    public int distributeCoins(TreeNode root) {
        numMoves=0;
            giveCoins(root);
        return numMoves;
    }
    public int giveCoins(TreeNode root){
        if(root==null)return 0;
        
        int left = giveCoins(root.left);
        int right = giveCoins(root.right);
        
        numMoves += Math.abs(left)+Math.abs(right);
        
        return root.val+ left+right-1;
    }
}