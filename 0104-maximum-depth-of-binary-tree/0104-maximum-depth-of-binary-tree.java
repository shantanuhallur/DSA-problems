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
    public int maxDepth(TreeNode root) {
        //Base Case -> null node has 0 depth.
        if(root == null) return 0;
        //Left recursive calls for depths of both.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Choosing maximum depth from both and adding 1 as i am 1 level greater from them.        
        return Math.max(leftDepth,rightDepth) + 1;
    }
}