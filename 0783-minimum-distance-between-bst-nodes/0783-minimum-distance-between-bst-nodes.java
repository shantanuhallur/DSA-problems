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
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    void minDiffInBST_01(TreeNode node) {
        //Base Case
        if(node==null) return;
        //Left Recursive Call
        minDiffInBST_01(node.left);
        //INORDER AREA -------------->>>
        
        if(prev != null) {
            int minVal =  node.val - prev.val;
            minDiff = Math.min(minDiff,minVal);
        }
        
        prev = node;
        //INORDER AREA -------------->>>
        //Left Recursive Call
        minDiffInBST_01(node.right);
    }
    public int minDiffInBST(TreeNode root) {
        minDiffInBST_01(root);
        return minDiff;
    }
}