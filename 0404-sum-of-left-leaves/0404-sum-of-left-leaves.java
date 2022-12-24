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
    int sum = 0;
    public void sumOfLeftLeaves_01(TreeNode node) {
        //Base Case return
        if(node == null) return;
        //left Node exists -> Node's left child's left and right are null
        if(node.left != null && node.left.left == null && node.left.right == null) sum += node.left.val;
        
        //Recursive Call to left and right Nodes.
        sumOfLeftLeaves_01(node.left);
        sumOfLeftLeaves_01(node.right);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves_01(root);
        return sum;
    }
}