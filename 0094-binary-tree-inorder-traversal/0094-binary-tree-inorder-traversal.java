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
        if(node.left != null){
            inorderTraversal_01(node.left,ans);
        }
        
        ans.add(node.val);
        
        if(node.right != null){
            inorderTraversal_01(node.right,ans);
         }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        inorderTraversal_01(root,ans);
        return ans;
    }
}