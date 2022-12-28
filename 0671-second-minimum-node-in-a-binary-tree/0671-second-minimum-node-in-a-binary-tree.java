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
    long min = (long)1e13;
    long smin = (long)1e13;
    public void findSecondMinimumValue_01(TreeNode node) {
        if(node==null) return;
        
        findSecondMinimumValue_01(node.left);
        findSecondMinimumValue_01(node.right);
        
        if(node.val < min) {
            smin = min;
            min = node.val;
        }
        else if(node.val<smin && node.val !=min) {
            smin = node.val;
        }
    }
    
    public int findSecondMinimumValue(TreeNode root) {
        findSecondMinimumValue_01(root);
        return smin==(long)1e13?-1:(int)smin;
    }
}