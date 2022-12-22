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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //Base Case
        if(root==null){
            TreeNode ourNode = new TreeNode(val);
            return ourNode;
        }
        
        if(val < root.val) {
            root.left = insertIntoBST(root.left,val);
        }
        else root.right = insertIntoBST(root.right,val);
        
        return root;
    }
}