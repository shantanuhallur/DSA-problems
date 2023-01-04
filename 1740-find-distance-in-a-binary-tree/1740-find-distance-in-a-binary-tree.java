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
    public TreeNode getLCA(TreeNode node,int p,int q) {
        if(node==null) return null;
        if(node.val == p || node.val ==q) return node;
        
        TreeNode left = getLCA(node.left,p,q);
        TreeNode right = getLCA(node.right,p,q);
        
        if(left!=null && right!=null) return node;
        
        return left!=null?left:right;
    }
    public int kDown(TreeNode node,int val, int len) {
        if(node==null) return 0;
        if(node.val==val) return len;
        
        int leftLen = kDown(node.left,val,len+1);
        if(leftLen >0) return leftLen;
        int rightLen = kDown(node.right,val,len+1);
        if(rightLen>0) return rightLen;
        
        return leftLen+rightLen;
    }
    public int findDistance(TreeNode root, int p, int q) {
        if(p==q) return 0;
        
        TreeNode lca = getLCA(root,p,q);
    
            int lenP = kDown(lca,p,0);
            int lenQ = kDown(lca,q,0);
            return lenP+lenQ;
    }
}