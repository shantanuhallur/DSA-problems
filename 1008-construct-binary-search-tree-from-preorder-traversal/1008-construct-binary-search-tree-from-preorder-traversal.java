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
    int idx = 0;
    public TreeNode bstFromPreorder_(int[] preorder,int lrange,int rrange) {
        if(idx >= preorder.length || preorder[idx] > rrange || preorder[idx] < lrange) 
            return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        
        root.left = bstFromPreorder_(preorder,lrange,root.val);
        root.right = bstFromPreorder_(preorder,root.val,rrange);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder_(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}