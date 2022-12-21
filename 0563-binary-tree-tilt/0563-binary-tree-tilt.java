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
    int tilt = 0;
    
    public int findTilt_01(TreeNode node) {
        //Base Case
        if(node==null) return 0;
        
        //Recursive Sumation of whole left Subtree
        int leftSumation = findTilt_01(node.left);
        
         //Recursive Sumation of whole left Subtree
        int rightSumation = findTilt_01(node.right);
        
        tilt += Math.abs(leftSumation-rightSumation);
        
        int sum = leftSumation + rightSumation + node.val;
            
        return sum;
    }
    
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        
        System.out.print(findTilt_01(root));
        
        return tilt;
    }
}