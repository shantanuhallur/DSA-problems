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

        
        boolean hasPath = dfs(root,targetSum-root.val);
        return hasPath;
    }
    public boolean dfs(TreeNode node,int target){
        if(node.left ==null && node.right == null && target==0)return true;
        boolean leftTrue=false;
        boolean rightTrue=false;
        
        if(node.left!=null){
             leftTrue = dfs(node.left,target-node.left.val);
        }
        
        if(node.right!=null){
             rightTrue = dfs(node.right,target-node.right.val);
        }
        
        return (leftTrue||rightTrue);
    }
}