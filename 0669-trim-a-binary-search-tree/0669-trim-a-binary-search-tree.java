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
    public TreeNode trim(TreeNode node, int low, int high) {
        if(node ==null) return null;
        if(node.val < low) {
            return node.right != null ? node.right : null;
        }
        if(node.val > high) {
            return node.left != null ? node.left : null;
        }
        
        node.left = trim(node.left,low,high);
        node.right = trim(node.right,low,high);
        
        return node;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        if(root.val < low) return trimBST(root.right,low,high);
        if(root.val > high) return trimBST(root.left,low,high);
        
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        
        return root;
    }
}