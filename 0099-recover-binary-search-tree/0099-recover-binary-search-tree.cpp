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
    TreeNode prev = null;
    TreeNode a = null;
    TreeNode b = null;
    
    public void recoverTree_01(TreeNode curr) {
        //Base Case
        if(curr == null) return;
        
        //Left Recursive Call
        recoverTree_01(curr.left);
        // INORDER ----- >>>>>>
        //check if prev is first set or not.
        if(prev!=null && prev.val > curr.val) {
            b = curr;
            if(a==null) a = prev;
        }
        
        prev = curr;
        // INORDER ----- >>>>>>
        //Right Recursive Call
        recoverTree_01(curr.right);
    }
    
    public void recoverTree(TreeNode root) {
        recoverTree_01(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}