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
    int tilt = 0;
    public int findSum(TreeNode node) {
        if(node == null) return 0;
        
        int leftSum = findSum(node.left);
        int rightSum = findSum(node.right);
        
        tilt += Math.abs(leftSum-rightSum);
        
        return (leftSum + rightSum + node.val);
    }
    
    public int findTilt(TreeNode root) {
        int sum = findSum(root);
        return tilt;
    }
}