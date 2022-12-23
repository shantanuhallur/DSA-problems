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
    public int sumRootToLeaf_01(TreeNode root, int sum) {
        if(root == null )return 0;
        
        sum = (2*sum) + root.val;
        if(root.left == null && root.right == null) return sum;
        int leftSum = sumRootToLeaf_01(root.left,sum);
        int rightSum = sumRootToLeaf_01(root.right,sum);
        
        int totalSum = leftSum+rightSum;
        
        return totalSum;
    }
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf_01(root,0);
    }
}