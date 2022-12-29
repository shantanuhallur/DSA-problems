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
    public int sumEvenGrandparent_01(TreeNode node) {
        if(node == null) return 0;
        int mySum = 0;
        int leftSum=0;
        int rightSum=0;
        
        leftSum = sumEvenGrandparent_01(node.left);
        rightSum = sumEvenGrandparent_01(node.right);
        
        if(node.val % 2 == 0) {
            //leftGranchChilds
            if(node.left!=null && node.left.left!=null) mySum += node.left.left.val;
            if(node.left!=null && node.left.right!=null) mySum += node.left.right.val;
            
            //Right GrandChilds
            if(node.right!=null && node.right.left!=null) mySum += node.right.left.val;
            if(node.right!=null && node.right.right!=null) mySum += node.right.right.val;
        }
        
        return leftSum+rightSum+mySum;
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent_01(root);
    }
}