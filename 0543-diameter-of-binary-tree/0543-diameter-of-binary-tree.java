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
    public class pair{
        int dia;
        int ht;
        
        pair(int dia,int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }
    
    public pair getMaxDia(TreeNode node) {
        //Base Case 
        if(node==null) return new pair(-1,-1);
        
        pair myAns = new pair(-1,-1);
        //recursive left and right calls
        pair leftAns = getMaxDia(node.left);
        pair rightAns = getMaxDia(node.right);
        //Calculate diameter through my node
        int diaMyNode = leftAns.ht + rightAns.ht + 2;
        //my answers max diameter
        myAns.dia = Math.max(Math.max(leftAns.dia,rightAns.dia),diaMyNode);
        //my answers max height
        myAns.ht = Math.max(leftAns.ht,rightAns.ht)+1;
        
        return myAns;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return getMaxDia(root).dia;
    }
}