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
    public int sumRootToLeaf_01(TreeNode node,int sum) {
        //Case when our node itself is null so tree doesnt exist.
        if(node == null) return 0;
        //calculate Pre sum.
        sum = (2*sum) + node.val;
        //Condition for recognizing leaf
        if(node.left ==null && node.right ==null) return sum;
        //left Whole left & right subtree's decimal sum
        int leftSum = sumRootToLeaf_01(node.left,sum);
        int rightSum = sumRootToLeaf_01(node.right,sum);
        //return this total Sum.
        int totalSum = leftSum + rightSum;
        
        return totalSum;
    }
    
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf_01(root,0);
    }
}