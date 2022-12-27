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
    TreeNode prev = null;
    TreeNode a = null;
    TreeNode b = null;
    public void recoverTree_01(TreeNode node) {
        if(node == null) return;
        recoverTree_01(node.left);
        
        if(prev!=null && prev.val>node.val) {
            b = node;
            if(a==null) a = prev;
        }
        
        prev = node;
        recoverTree_01(node.right);
    }
    public void recoverTree(TreeNode root) {
        recoverTree_01(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}