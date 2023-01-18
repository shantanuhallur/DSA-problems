/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    TreeNode prev = null;
    void inOrder(TreeNode node,TreeNode p) {
        if(node == null) return;
        
        inOrder(node.left,p);
        
        if(prev != null && prev == p) ans = node;
        
        
        prev = node;
        inOrder(node.right,p);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root,p);
        return ans;
    }
}