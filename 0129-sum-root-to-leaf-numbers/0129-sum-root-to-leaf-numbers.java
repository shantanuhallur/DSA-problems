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
    int sum = 0;
    void getSum(TreeNode node,int currSum) {
        if(node == null) return;
        currSum = currSum*10 + node.val;
            
        if(node.left == null && node.right == null) {
            sum += currSum;
            return;
        }
        
        
        getSum(node.left,currSum);
        getSum(node.right,currSum);
    } 
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return sum;
    }
}