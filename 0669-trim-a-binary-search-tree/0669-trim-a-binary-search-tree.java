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
 *     }0
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //base case 
        if(root == null) return null;
        //Case 1 
        if(root.val < low) return trimBST(root.right,low,high);
        //Case 2
        if(root.val > high) return trimBST(root.left,low,high);
        //Case 3 in range    
        
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        
        return root;
    }
}