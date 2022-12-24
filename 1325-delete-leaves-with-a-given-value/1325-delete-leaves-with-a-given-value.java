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
    public TreeNode removeLeafNodes_01(TreeNode node, int target) {
        if(node==null) return null;
        
        node.left = removeLeafNodes_01(node.left,target);
        
        node.right = removeLeafNodes_01(node.right,target);
        
        if(node.val == target && node.left == null && node.right == null) return null;
        else return node;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        
        return removeLeafNodes_01(root,target);
    }
}