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
    // int idx = 0;
    public TreeNode bstFromPreorder_(int[] preorder,int lrange,int rrange,int[] arr) {
        if(arr[0] >= preorder.length || preorder[arr[0]] > rrange || preorder[arr[0]] < lrange) 
            return null;
        
        TreeNode root = new TreeNode(preorder[arr[0]++]);
        
        root.left = bstFromPreorder_(preorder,lrange,root.val,arr);
        root.right = bstFromPreorder_(preorder,root.val,rrange,arr);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] arr = {0};
        return bstFromPreorder_(preorder,-(int)1e8,(int)1e8,arr);
    }
}