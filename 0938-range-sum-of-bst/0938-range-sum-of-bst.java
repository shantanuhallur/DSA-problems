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
    int rangeSum = 0;
    public void rangeSumBST_01(TreeNode node, int low, int high) {
        //Base Case -->>>
        if(node == null) return;
        //condition to check if we should add the current nodes value or not?
        if(low <= node.val && node.val <= high) rangeSum += node.val;
         //condition to check if we should recurse in left & right or not.
        if(low <= node.val) rangeSumBST_01(node.left,low,high);
        
        if(node.val<= high) rangeSumBST_01(node.right,low,high);
        
        
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumBST_01(root,low,high);
        return rangeSum;
    }
}