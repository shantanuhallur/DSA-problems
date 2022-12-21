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
    public void inorderTraversal_01(TreeNode node,ArrayList<Integer> ans) {
        //Base Case
        if(node == null) return;
        
        //recursive left call
        inorderTraversal_01(node.left,ans);
        // INORDER ----------->
       
        ans.add(node.val);
        
        // INORDER ----------->
        //recursive right call
        inorderTraversal_01(node.right,ans);
        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        inorderTraversal_01(root,ans);
        return ans;
    }
}