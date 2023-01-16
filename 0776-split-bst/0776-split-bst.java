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
    
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] result = new TreeNode[2];
        if(root==null) return result;
        
        if(root.val<=target) {
            result[0] = root;
            TreeNode[] rightSubTree = splitBST(root.right,target);
            root.right = rightSubTree[0];
            result[1] = rightSubTree[1];
        }
        else {
            result[1] = root;
            TreeNode[] leftSubTree = splitBST(root.left,target);
            root.left = leftSubTree[1];
            result[0] = leftSubTree[0];
        }
        
        return result;
    }
}