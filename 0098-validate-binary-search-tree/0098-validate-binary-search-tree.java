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
    boolean isBST = true;
    TreeNode prev = null;
    public void traverseInorder(TreeNode node) {
        //base Case
        if(node == null) return;
        
        //left recursive call
        traverseInorder(node.left);
        //Inorder area ---->>>>>>
        //condition
        if(prev!= null && prev.val >= node.val) isBST = false;
        //update prev
        prev = node;
        //Inorder area ---->>>>>>
        //right recursive call
        traverseInorder(node.right);
        
    }
    public boolean isValidBST(TreeNode root) {
        traverseInorder(root);
        return isBST;
    }
}