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
    class pair{
        int isRob;
        int notRob;
        
        pair(int isRob,int notRob) {
            this.isRob = isRob;
            this.notRob = notRob;
        }
    }
    
     //Base Case
    //Recursive left and right call of faith
    //when my current node is roobed
    //when my current node is not robbed
    pair getMaxMoney(TreeNode node) {
        //Base Case
        if(node == null) return new pair(0,0);
        
        pair myAns = new pair(0,0);
        //Recursive left and right call of faith
        pair leftAns = getMaxMoney(node.left);
        pair rightAns = getMaxMoney(node.right);
        //when my current node is roobed
        myAns.isRob = leftAns.notRob + rightAns.notRob + node.val;
        //when my current node is not robbed
        myAns.notRob = Math.max(leftAns.notRob,leftAns.isRob) + 
                       Math.max(rightAns.notRob,rightAns.isRob);
        
        return myAns;
    }
    
    public int rob(TreeNode root) {
        pair rootAns = getMaxMoney(root);
        return Math.max(rootAns.isRob,rootAns.notRob);
    }
}