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
    public boolean areEqual(TreeNode root1,TreeNode root2) {
        if(root1==null && root2 == null) return true; //both have null node in same pos
        if(root1 ==null || root2 == null) return false; //only 1 has node other has null in structure
        if(root1.val != root2.val) return false; //same structure but different value of nodes
        
        boolean left = areEqual(root1.left,root2.left);
        boolean right = areEqual(root1.right,root2.right);
        
        return (left && right );
    }
    public boolean dfs(TreeNode node,int data,TreeNode subRoot) {
        if(node == null) return false;
        
        if(node.val == data) {
            boolean ans = areEqual(node,subRoot);
            if(ans) return true;
        }
        
        boolean leftAns = dfs(node.left,data,subRoot);
        boolean rightAns = dfs(node.right,data,subRoot);
        
        return leftAns||rightAns;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot.val,subRoot);
    }
}