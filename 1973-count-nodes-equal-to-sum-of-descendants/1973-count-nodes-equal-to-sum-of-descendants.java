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
    int countN = 0;
    public int equalToDescendants_01(TreeNode node) {
        //Base Case
        if(node == null) return 0;
        //Recursive Faith Call
        int leftSum = equalToDescendants_01(node.left);
        int rightSum = equalToDescendants_01(node.right);
        //Our condition to check of all the descendents have the same val as my node
        if(leftSum+rightSum == node.val) countN++;
        //return my nodes sum added to leftsum and rightsum to my parent node
        return leftSum + rightSum + node.val;
        
    }
    public int equalToDescendants(TreeNode root) {
        equalToDescendants_01(root);
        return countN;
    }
}