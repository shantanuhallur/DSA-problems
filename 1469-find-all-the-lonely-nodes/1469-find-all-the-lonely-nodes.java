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
    public boolean getLonelyNodes_01(TreeNode node,List<Integer> ans) {
        if(node == null) return false;
        
        boolean leftChild = getLonelyNodes_01(node.left,ans);
        boolean rightChild =  getLonelyNodes_01(node.right,ans);
        
        if(leftChild && !rightChild) {
            ans.add(node.left.val);
        }
        
        if(rightChild && !leftChild) {
            ans.add(node.right.val);
        }
        
        return true;
 
    }
        
    
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getLonelyNodes_01(root,ans);
        return ans;
    }
}