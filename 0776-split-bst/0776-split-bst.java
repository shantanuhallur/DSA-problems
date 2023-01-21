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
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] tree = new TreeNode[2];
        if(root==null) return new TreeNode[2];
        
        if(root.val <= target) {
            tree[0] = root;
            TreeNode[] rAns = splitBST(root.right,target);
            root.right = rAns[0];
            tree[1] = rAns[1];
        }
        else if(root.val>target) {
            tree[1] = root;
            TreeNode[] lAns = splitBST(root.left,target);
            root.left = lAns[1];
            tree[0] = lAns[0];
         }
        return tree;
    }
}