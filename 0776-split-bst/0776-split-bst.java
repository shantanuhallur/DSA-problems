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
        TreeNode[] res = new TreeNode[2];
        if(root==null) return res;
        if(root.val<=target) {
            res[0] = root;
            TreeNode[] lAns = splitBST(root.right,target);
            root.right = lAns[0];
            res[1] = lAns[1];
        }
        else {
            res[1] = root;
            TreeNode[] rAns = splitBST(root.left,target);
            root.left = rAns[1];
            res[0] = rAns[0];
        }
        return res;
    }
}