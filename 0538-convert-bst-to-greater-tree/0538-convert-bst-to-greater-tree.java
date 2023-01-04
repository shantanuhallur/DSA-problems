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
    TreeNode prev = null;
    int cSum =0;
    public void convert(TreeNode node) {
        if(node == null) return;
        
        convert(node.right);
        cSum += node.val;
        node.val = cSum;
        prev = node;
        convert(node.left);
        
    }
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
}