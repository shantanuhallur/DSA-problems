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
    boolean isValidTree = true;
    TreeNode prev = null;
    public void isValidBST_01(TreeNode root) {
        if(root == null) return;
        
        isValidBST(root.left);
        if(prev!=null && prev.val >= root.val)isValidTree = false;
        prev = root;
        isValidBST(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        isValidBST_01(root);
        return isValidTree;
    }
}