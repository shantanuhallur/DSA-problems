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
    
    public TreeNode construct(int[] post,int ppsi,int ppei,int[] pre,int psi,int pei) 
    {
        if(psi>pei) return null;
        
        TreeNode node = new TreeNode(pre[psi]);
        
        if(psi==pei) return node; //saves from overflow for the while loop below pre[psi + 1]
        
        int idx = ppsi;
        
        while(post[idx] != pre[psi + 1])idx++;
        
        int tel = idx - ppsi + 1;
        
        node.left = construct(post,ppsi,idx,pre,psi+1,psi+tel);
        node.right = construct(post,idx+1,ppei-1,pre,psi+tel+1,pei);
        
        return node;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(postorder,0,postorder.length-1,preorder,0,preorder.length-1);
    }
}