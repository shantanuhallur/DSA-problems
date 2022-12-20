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
    public int findSum(TreeNode node,int[] ans) {
        if(node == null) return 0;
        
        int leftSum = findSum(node.left,ans);
        int rightSum = findSum(node.right,ans);
        
        ans[0] += Math.abs(leftSum-rightSum);
        
        return (leftSum + rightSum + node.val);
    }
    
    public int findTilt(TreeNode root) {
        int[] ans = new int[1];
        int sum = findSum(root,ans);
        return ans[0];
    }
}