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
    public void preorderTraversal_01(TreeNode node,ArrayList<Integer> ans) {
        ans.add(node.val);
        
        if(node.left != null){
            preorderTraversal_01(node.left,ans);
        }
        
        if(node.right != null){
            preorderTraversal_01(node.right,ans);
         }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        //Base case
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)  return list;
        preorderTraversal_01(root,list);
        
        return list;
    }
}