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
        if (root == null) return new TreeNode(val);
        
        TreeNode lastNode =null;
        TreeNode pos = root;
        
        while(pos != null) {
            if(pos.val > val) {
                lastNode = pos;
                pos = pos.left;
            }
            else {
                lastNode = pos;
                 pos = pos.right;
            }     
        }
        
        if(lastNode.val > val) {
            lastNode.left = new TreeNode(val);
        }
        else{
            lastNode.right = new TreeNode(val);
        }
        
        return root;
    }
}