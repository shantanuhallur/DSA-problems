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
    //expectation it will tell us if symmetric or not
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSymmetric(root.left,root.right);
    }
    
    public boolean isSymmetric(TreeNode rootLeft,TreeNode rootRight){
        if(rootLeft == null && rootRight == null)return true;
        if(rootLeft == null || rootRight == null)return false;
        
        // If the value of the root of the left part is not equal to the value of the root of the right         part...
        if (rootLeft.val != rootRight.val)
		    return false;
        //THJIS IS CRITICAL
        if (!isSymmetric(rootLeft.left, rootRight.right))
		    return false;
	    if (!isSymmetric(rootLeft.right, rootRight.left))
		    return false;
        
        return true;
    }
}