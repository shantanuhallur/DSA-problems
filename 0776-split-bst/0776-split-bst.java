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
    public TreeNode[] split(TreeNode node,int target) {
        TreeNode[] res = new TreeNode[2];
        if(node == null) return res;
        
        if(node.val <= target) {
            res[0] = node;
            TreeNode[] rAns = split(node.right,target);
            node.right = rAns[0];
            res[1] = rAns[1];
        }
        else if(node.val > target) {
            res[1] = node;
            TreeNode[] lAns = split(node.left,target);
            node.left = lAns[1];
            res[0] = lAns[0];
        }
        return res;
    }
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] ans = split(root,target);
        return ans;
    }
}