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
    //expectation function will give max height.
    public int maxDepth(TreeNode root) {
        //base case
        if(root==null)return 0;
        //faith it will give us depth of its nodes
        int left =  maxDepth(root.left);
        int right = maxDepth(root.right);
        //expectation -> faith
        return Math.max(left,right)+1;
    }
}