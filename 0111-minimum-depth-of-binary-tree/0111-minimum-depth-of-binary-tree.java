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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int height = dfs(root);
        return height;
    }
    
    public int dfs(TreeNode node){
        //if(node==null)return 0;
        if(node.left == null && node.right == null)return 1;
        
        int leftHeight= Integer.MAX_VALUE;
        int rightHeight= Integer.MAX_VALUE;
        
        if(node.left!=null){
             leftHeight=  dfs(node.left);    
        }
        if(node.right!=null){
            rightHeight= dfs(node.right);
        }
        
        return 1+Math.min(leftHeight,rightHeight);
    }
}