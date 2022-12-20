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
    TreeNode dummy = new TreeNode(1);
    TreeNode prev = dummy;
    
    public void makeBSTLinear(TreeNode node) {
        if(node == null) return;
        //Left Recursive Call
        makeBSTLinear(node.left);
        //INORDER ---->
        //Make Current Node null
        node.left = null;
        //Attach node to prev's Right
        prev.right = node;
        //Move Prev ahead
        prev = node;
        //INORDER ---->
        //Right Recursive Call
        makeBSTLinear(node.right);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        makeBSTLinear(root);
        return dummy.right;
    }
}