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
    
    public int evaluateTree_01(TreeNode root) {
        int operation=0;
        int right = 0;
        int left = 0;
        
        if(root.left == null && root.right==null) {
            return root.val;
        }
        
        if(root.left != null) {
            left = evaluateTree_01(root.left);
        }
        
        if(root.right != null) {
            right = evaluateTree_01(root.right);
        }
        
        
        // OR Opearation 
        if(root.val == 2){
            operation = (left | right);
        }
        
        // AND Opearation 
        if(root.val == 3){
            operation = (left & right);
        }
        
        root.val = operation;
        return operation;
    }
    public boolean evaluateTree(TreeNode root) {
        int ans =  evaluateTree_01(root);
        return ans==1 ? true : false;
    }
}