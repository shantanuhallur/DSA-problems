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
    int moves =0;
    int distribute(TreeNode node) {
        //base case
        if(node == null) return 0;
        
        //left and right recursive call of faith for getting ex/Def coins
        int leftExDef = distribute(node.left);
        int rightExDef = distribute(node.right);
        //as moves has no convention we will add all the compulsory moves from left and right
        moves += Math.abs(leftExDef) + Math.abs(rightExDef);
        
        //return all the  excessive or deficit number of coins remained or to offer to our parent.
        return leftExDef+rightExDef+node.val - 1;
    }
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return moves;
    }
}