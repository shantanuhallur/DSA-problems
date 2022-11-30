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
    
    TreeNode a=null,b=null,prev=null;
    public boolean recoverTree_01(TreeNode root) {
        if(root==null) return true;
        
        if(!recoverTree_01(root.left)) {
            return false;
        }
        //inorder area ***
        if(prev!=null && prev.val>root.val) {
            b = root;
            if(a==null) a=prev;
            else return false;
        }
        prev = root;
        //inorder area ***
        if(!recoverTree_01(root.right)) {
            return false;
        }
        
        return true;
    }
    
    public void recoverTree(TreeNode root) {
        recoverTree_01(root);
        TreeNode temp = new TreeNode();
        temp.val = a.val;
        a.val = b.val;
        b.val = temp.val;
    }
}