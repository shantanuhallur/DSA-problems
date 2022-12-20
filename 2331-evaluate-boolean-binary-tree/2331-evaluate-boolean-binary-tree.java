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
    public int evaluateTree_01(TreeNode node) {
        //Leaf Node base case
        if(node.left == null && node.right ==null) return node.val;
        
        int leftAns = 0;
        int rightAns = 0;
        int operation = 0;
        //Left Recursive Call
        leftAns = evaluateTree_01(node.left);
        //Right Recursive Call
        rightAns = evaluateTree_01(node.right);
        //OR operation
        if(node.val == 2) {
            operation = (leftAns | rightAns);
        }
        //AND opeartion
        if(node.val == 3) {
            operation = (leftAns & rightAns);
        }
        
        return operation;
    }
    
    public boolean evaluateTree(TreeNode root) {
        return evaluateTree_01(root) == 1 ? true : false;
    }
}