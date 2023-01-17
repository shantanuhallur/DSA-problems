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
    int maxPath = 1;
    public void getPath(TreeNode node,int parVal,int pathLen) {
        if(node == null) return;
        int currPathLen = 1;
        if(node.val - 1 == parVal) currPathLen += pathLen;
        if(maxPath<currPathLen) maxPath=currPathLen;
        getPath(node.left,node.val,currPathLen);
        getPath(node.right,node.val,currPathLen);
    }
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        getPath(root,root.val-1,0);
        return maxPath;
    }
}