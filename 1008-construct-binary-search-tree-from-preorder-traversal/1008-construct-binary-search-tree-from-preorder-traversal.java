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
    public TreeNode buildBST(int[] preorder,int lRange,int rRange) {
        //Base Case
        if(idx == preorder.length || preorder[idx] < lRange || preorder[idx]>rRange) return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        //Recursive faith calls for left and right nodes of root.
        root.left = buildBST(preorder,lRange,root.val);
        root.right = buildBST(preorder,root.val,rRange);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        //return the built tree.
        return buildBST(preorder,-1,1001);
    }
}