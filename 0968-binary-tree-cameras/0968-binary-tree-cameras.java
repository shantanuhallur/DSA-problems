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
    int cameras=0;
    int getInfo(TreeNode node) {
        if(node == null) return 0;
        
        int left = getInfo(node.left);
        int right = getInfo(node.right);
        
        if(left == -1 || right == -1) {
            cameras++;
            return 1;
        }
        
        if(left ==1  || right == 1) return 0;
        
        return -1;
    }
    int minCameraCover(TreeNode root) {
        int rootInfo = getInfo(root);
        if(rootInfo == -1) cameras++;
        return cameras;
    }
}