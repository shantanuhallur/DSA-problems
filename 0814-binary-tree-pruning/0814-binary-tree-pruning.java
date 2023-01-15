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
    public boolean modifiedTree(TreeNode node) {
        //Base Case if node is null no node exists with value as 1
        if(node == null) return false;
        //left and right recursive call of faith
        boolean leftContains1 = modifiedTree(node.left);
        boolean rightContains1 = modifiedTree(node.right);
        //if there exists no node with value 1 in my left and right subtree ill prune it.
        if(!leftContains1) node.left = null;
        if(!rightContains1) node.right = null;
        
        return leftContains1 || rightContains1 || node.val == 1;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        modifiedTree(root);
        //check if root itself has been pruned to a leaf and its val is 0 if yes prune it.
        if(root.left == null && root.right == null && root.val==0) return null;
        return root;
    }
}