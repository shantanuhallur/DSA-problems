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
        int withRob;
        int withoutRob;
        
        pair(int withRob,int withoutRob) {
            this.withRob = withRob;
            this.withoutRob = withoutRob;
        }
    }
    
    public pair getMaxRob (TreeNode node) {
        if(node == null) return new pair(0,0);
        
        pair leftAns = getMaxRob(node.left);
        pair rightAns = getMaxRob(node.right);
        pair myAns = new pair(0,0);
        //withRob
        myAns.withRob = leftAns.withoutRob + rightAns.withoutRob + node.val;
        //without rob
        myAns.withoutRob = Math.max(leftAns.withRob,leftAns.withoutRob) +
                           Math.max(rightAns.withRob,rightAns.withoutRob);
        
        return myAns;
    }
    public int rob(TreeNode root) {
        pair rootAns = getMaxRob(root);
        return Math.max(rootAns.withRob,rootAns.withoutRob);
    }
}