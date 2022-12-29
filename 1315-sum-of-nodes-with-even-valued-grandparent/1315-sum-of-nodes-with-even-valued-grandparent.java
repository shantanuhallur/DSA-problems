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
        //Base Case
        if(node==null) return 0;
        
        int mySum = 0;
        int leftChildrenSum = 0;
        int rightChildrenSum = 0;
        //Recursive left and right calls asking sum of their grandchilren if exist
        leftChildrenSum = sumEvenGrandparent_01(node.left);
        rightChildrenSum = sumEvenGrandparent_01(node.right);
        
        //if my node is even
        if(node.val%2==0) {
            //add LEFT grandchildren
            if(node.left!=null && node.left.left !=null) mySum += node.left.left.val;
            if(node.left!=null && node.left.right !=null) mySum += node.left.right.val;
            
            //add RIGHT grandchildren
            if(node.right!=null && node.right.left!=null) mySum += node.right.left.val;
            if(node.right!=null && node.right.right!=null) mySum += node.right.right.val;
        }
        
        return leftChildrenSum+rightChildrenSum+mySum;
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent_01(root);
    }
}