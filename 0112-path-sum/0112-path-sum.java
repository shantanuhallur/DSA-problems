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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        boolean hasPath = dfs(root,targetSum,Sum+root.val);
        return hasPath;
    }
    int Sum = 0;
    public boolean dfs(TreeNode node,int target,int Sum){
        if(node.left == null && node.right==null && Sum == target){
            return true;
        }
        boolean left = false;
        boolean right = false;
        
        if(node.left!=null) {
            left = dfs(node.left,target,Sum+node.left.val);
        }
        
        if(node.right!=null) {
            right = dfs(node.right,target,Sum+node.right.val); 
        }

        return (left||right);
    }
}