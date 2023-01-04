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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)return true; //both roots are null so tree is equal
        if(root1 == null || root2==null)return false; //only one of the trwo nodes is null return false
        if(root1.val != root2.val) return false;
        
        //check if the tree is equal normally
        if(flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right)) {
            return true;
        }
        //check if the tree is flip equal
        else if(flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left)) {
            return true;
        }
        
        return false;
    }
}