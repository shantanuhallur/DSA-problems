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
        //Base Case
        if(node==null) return false;
        //Left Recursive call
        boolean hasLeftChild = getLonelyNodes_01(node.left,ans);
        //Right Recursive call
        boolean hasRightChild = getLonelyNodes_01(node.right,ans);
        //if has left child buit not right child.
        if(hasLeftChild && !hasRightChild) {
            ans.add(node.left.val);
        }
        //if has right child buit not left child.
        if(hasRightChild && !hasLeftChild) {
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