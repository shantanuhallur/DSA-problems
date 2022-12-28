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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        
        if(root.left == null && root.right == null){
            return -1;
        }
        
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        
        if(root.val == root.left.val) leftVal = findSecondMinimumValue(root.left);
        if(root.val == root.right.val) rightVal = findSecondMinimumValue(root.right);
        
        if(leftVal!=-1 && rightVal!=-1) {
            return Math.min(leftVal,rightVal);
        } else if(leftVal!=-1) {
            return leftVal;
        } else {
            return rightVal;
        }
    }
}