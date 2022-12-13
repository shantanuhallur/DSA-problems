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
    public class myPair {
        int isRobbed=0;
        int notRobbed=0;
        myPair() { }
        myPair(int isRobbed,int notRobbed) {
            this.isRobbed = isRobbed;
            this.notRobbed = notRobbed;
        }
    }
    
    public myPair rob_(TreeNode node) {
        if(node==null)return new myPair(0,0);
        
        myPair lans = rob_(node.left);
        myPair rans = rob_(node.right);
        
        myPair myAns = new myPair(0,0);
        myAns.isRobbed = node.val + lans.notRobbed + rans.notRobbed;
        //CRUX OF PROBLEM ... if i dont rob my current house,
        myAns.notRobbed = Math.max(lans.isRobbed,lans.notRobbed) + Math.max(rans.isRobbed,rans.notRobbed);
        
        return myAns;
    }
    
    public int rob(TreeNode root) {
        myPair ans = rob_(root);
        return Math.max(ans.isRobbed,ans.notRobbed);
    }
}