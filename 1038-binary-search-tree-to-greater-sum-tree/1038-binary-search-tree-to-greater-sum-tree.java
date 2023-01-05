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
    int sum =0;
    TreeNode prev = null;
    void convert(TreeNode node) {
        if(node == null) return;
        
        convert(node.right);
        
        node.val += sum;
        sum = node.val;
        
        prev = node;
        convert(node.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        convert(root);
        return root;
    }
}