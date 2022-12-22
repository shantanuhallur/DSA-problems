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
    boolean isUnivalTree_01(TreeNode node,int val) {
        if(node == null) return true;   
        
        boolean hasLeft = isUnivalTree_01(node.left,val);
        boolean hasRight = isUnivalTree_01(node.right,val);
        
        if(node.val == val && hasLeft && hasRight)return true;
        else return false;
    }
    
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        int val = root.val;
        return isUnivalTree_01(root,val);
    }
}