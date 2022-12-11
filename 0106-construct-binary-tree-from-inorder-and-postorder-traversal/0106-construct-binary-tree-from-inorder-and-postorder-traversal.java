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
    
    public TreeNode buildTree(int[] inorder,int isi,int iei,int[] postorder,int psi, int pei) {
        if(psi>pei) return null;
        //construct root node;
        TreeNode node = new TreeNode(postorder[pei]);
        int idx = isi;
        //find in inorder idx element;
        while(inorder[idx] != postorder[pei])idx++;
        int tel = idx - isi; //total no of elements
        node.left = buildTree(inorder,isi,idx-1,postorder,psi,psi+tel-1);
        node.right = buildTree(inorder,idx+1,iei,postorder,psi+tel,pei-1);
        
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}