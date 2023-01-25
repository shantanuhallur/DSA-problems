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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        //Base Case
        if(root==null) return null;
        //check if leaf node is insufficient or not
        if(root.left == null && root.right == null) return root.val < limit ? null : root;
        //left and right recursive call to delete all the insufficient nodes from paths through me
        root.left = sufficientSubset(root.left,limit-root.val);
        root.right = sufficientSubset(root.right,limit-root.val);
        //if all paths through me are insufficient then im also insufficient by deifinition or else im not
        return root.left == root.right ? null:root;
    }
}