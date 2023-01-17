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
    int minAbsDiff = (int)1e8;
    TreeNode prev = null;
    public void inOrder(TreeNode node) {
        //Base Case
        if(node == null) return;
        
        //Left and right recursive calls
        inOrder(node.left);
        //INORDER AREA ---->>>
        //minimize abs diff if needed
        if(prev!=null) {
            if(node.val - prev.val < minAbsDiff) minAbsDiff = node.val - prev.val;
        }
        prev = node;
        //INORDER AREA ---->>>
        inOrder(node.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minAbsDiff;
    }
}