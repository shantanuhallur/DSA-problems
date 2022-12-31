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
        //Base case if root is null
        if(root == null) return -1;
        
        //If leaf , second min doesnt exist
        if(root.left == null && root.right == null) return -1;
        
        int leftSMin = root.left.val;
        int rightSMin = root.right.val;
        
        //Conditional Recursive Faith of call
        if(root.val == root.left.val) leftSMin = findSecondMinimumValue(root.left);
        
        if(root.val == root.right.val) rightSMin = findSecondMinimumValue(root.right);
        
        //if there exists a second min val in leftSMin or rightSMin
        if(leftSMin !=-1 && rightSMin != -1) {
            return Math.min(leftSMin,rightSMin);
        }
        else if (leftSMin != -1) {
            return leftSMin;
        }
        else return rightSMin;
    }
}