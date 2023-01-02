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
    public int height(TreeNode node) {
        //Base Case
        if(node==null) return 0;
        //Recusive call of faith
        int leftH = height(node.left);
        int rightH = height(node.right);
        //calculate my node's height 
        return Math.max(leftH,rightH) + 1;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //base case
        if(root==null) return null;
        //get left and right rubtreeH
        int leftSubTreeH = height(root.left);
        int rightSubTreeH = height(root.right);
        
        if(leftSubTreeH==rightSubTreeH) return root;
        else if(leftSubTreeH<rightSubTreeH) return subtreeWithAllDeepest(root.right);
        else return subtreeWithAllDeepest(root.left);
    }
}