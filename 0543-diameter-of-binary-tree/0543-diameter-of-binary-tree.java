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
    
    public int height(TreeNode node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
        // //EDEGS
        // return node == null ? 0 : Math.max(size(node.left), size(node.right)) + 1; // NODES
    }
    
    public int diameterOfBinaryTree_01(TreeNode root) {
        if(root==null)
            return -1;
        int leftDia = diameterOfBinaryTree_01(root.left);
        int rightDia = diameterOfBinaryTree_01(root.right);
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.max(Math.max(leftDia,rightDia),leftHeight+rightHeight+2);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;  
        return diameterOfBinaryTree_01(root);
    }
}