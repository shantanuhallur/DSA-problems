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
    TreeNode prev = null;
    public void convert(TreeNode node) {
        //Base case
        if(node == null) return;
        
        //right call first then left call.
        convert(node.right);
        // INORDER AREA ------>>>>
        node.val += greaterSum;
        greaterSum = node.val;
        //update prev node to curr node
        prev = node;
        // INORDER AREA ------>>>>
        convert(node.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        convert(root);
        return root;
    }
}