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
    int parent = -1;
    public int getDepth(TreeNode node,int depth,int target) {
        //Base Case
        if(node.val == target) return depth;
        //left and right DFS/Recursive calls
        if(node.left!=null) {
            //check if curr node is a parent to my target node
            if(node.left.val == target) parent = node.val;
            //get height form child
            int lAns = getDepth(node.left,depth+1,target);
            if(lAns != 0) return lAns;
        }
        if(node.right!=null) {
            //check if curr node is a parent to my target node
            if(node.right.val == target) parent = node.val;
            //get height form child
            int rAns = getDepth(node.right,depth+1,target);
            if(rAns != 0) return rAns;
        }
        return 0;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        //get dep & par for X
        int depth1 = getDepth(root,0,x);
        int par1 = parent;
        parent = - 1;
        //get dep & par for Y
        int depth2 = getDepth(root,0,y);
        int par2 = parent;
        //Check if both are Cousin or not.
        return depth1 == depth2 && par1 != par2 ? true : false;
    }
}