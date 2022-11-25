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
    int maxSumNTN=-(int)1e9;
    public int maxPathSum_01(TreeNode root) {
        if(root==null) return 0;
        
        int leftMaxPathSum =  maxPathSum_01(root.left);
        int rightMaxPathSum =  maxPathSum_01(root.right);
        
       int MaxTillRoot = Math.max(leftMaxPathSum,rightMaxPathSum) + root.val;
       maxSumNTN =  Math.max(Math.max(maxSumNTN,MaxTillRoot),Math.max(root.val,leftMaxPathSum+rightMaxPathSum+root.val));
        //maxCalculation.
        
        return Math.max(MaxTillRoot,root.val); //faith
    }
    
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        maxPathSum_01(root);
        return maxSumNTN;
    }
}