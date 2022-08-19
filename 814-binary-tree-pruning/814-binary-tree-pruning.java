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
    public TreeNode pruneTree(TreeNode root) {
        if (root ==null) return null;
        containsOne(root);
        if(root.val==0 && root.left==null && root.right==null) return null;
        return root;
    }
    
    public boolean containsOne(TreeNode node){
        if(node==null)return false;        
        
        boolean left_contains = containsOne(node.left);
        boolean right_contains = containsOne(node.right);
        
        if(!left_contains){
            node.left=null;
        }
        if(!right_contains){
            node.right=null;
        }
        
        return node.val == 1 || left_contains || right_contains;
    }
}