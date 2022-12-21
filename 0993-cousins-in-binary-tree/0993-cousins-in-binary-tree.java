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
    int par = -1;
    public int getDepth(TreeNode node,int depth,int num) {
                
        if(node.val == num) return depth;
        
        if(node.left != null) {
            if(node.left.val == num) par = node.val;
            int leftAns = getDepth(node.left,depth+1,num);
            if(leftAns >0) return leftAns;
        }
        
        if(node.right != null) {
            if(node.right.val == num) par = node.val;
            int rightAns = getDepth(node.right,depth+1,num);
            if(rightAns >0) return rightAns;
        }
        return 0;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int depth1 = getDepth(root,0,x);
        int par1 = par;
        par = -1;
        int depth2 = getDepth(root,0,y);
        int par2 = par;
        return (depth1 == depth2 && par1 != par2 ? true : false);
    }
}