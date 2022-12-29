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
    int longest = -1;
    public int longestZigZag_01(TreeNode node,int path) {
        if(node==null) return 0;
        //left & right recursive calls
        int leftLongestPath = longestZigZag_01(node.left,1);
        int rightLongestPath = longestZigZag_01(node.right,2);
        //IF i am the left child of zigzagPath
        if(path == 1) {
            if(rightLongestPath+1 > longest) longest = rightLongestPath+1;
            return rightLongestPath + 1;
        }
        //IF i am the right child of zigzagPath
        if(path == 2) {
            if(leftLongestPath+1 > longest) longest = leftLongestPath+1;
            return leftLongestPath+1;
        }
        else return Math.max(leftLongestPath,rightLongestPath);
    }
    
    public int longestZigZag(TreeNode root) {
        int ans = longestZigZag_01(root,0);
        return Math.max(ans,longest);
    }
}