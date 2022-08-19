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
    public boolean isUnivalTree(TreeNode root) {
        int x = root.val;
     return isUnival(root,x);   
    }
    public boolean isUnival(TreeNode root,int x){
         boolean right;
         boolean left;
        if(root == null) return true;
        if(root.val!=x)return false;
        else{
             left = isUnival(root.left,x);
             right = isUnival(root.right,x);
        }
        return left && right;
    }
}