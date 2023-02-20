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
    public int[] largestBST(TreeNode node) {
        if(node==null) return new int[]{(int)1e6,-(int)1e6,0};
        
        int[] l = largestBST(node.left);
        int[] r = largestBST(node.right);
        if(node.val >l[1] && node.val < r[0]) {
            return new int[] {Math.min(l[0],node.val),Math.max(node.val,r[1]),l[2]+r[2]+1};
        }
        else return new int[]{-(int)1e6,(int)1e6,Math.max(l[2],r[2])};
    }
    public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }
}