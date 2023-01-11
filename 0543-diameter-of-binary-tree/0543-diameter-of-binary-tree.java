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
    class pair {
        int dia;
        int ht;
        
        pair(int dia,int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }
    
    public pair getAns(TreeNode node) {
        if(node==null) return new pair(-1,-1);
        
        pair leftAns = getAns(node.left);
        pair rightAns = getAns(node.right);
        
        pair myAns = new pair(-1,-1);
        int diaThroughMe = leftAns.ht + rightAns.ht + 2;
        myAns.dia = Math.max(Math.max(leftAns.dia,rightAns.dia),diaThroughMe); 
        myAns.ht = Math.max(leftAns.ht,rightAns.ht) + 1;
        
        return myAns;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return getAns(root).dia;
    }
}