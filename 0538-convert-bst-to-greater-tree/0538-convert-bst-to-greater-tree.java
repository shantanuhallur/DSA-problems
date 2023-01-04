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
    int greaterSum = 0;
    public void traverse(TreeNode node) {
        //Base Case
        if(node == null) return;
        //right recursive call
        traverse(node.right);
        //INORDER AREA --------->>
         node.val += greaterSum;   
         //cumulative greater sum 
         greaterSum = node.val; 
        //INORDER AREA --------->>    
        //left recursive call
        traverse(node.left);
        
    }
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
}