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
        if(node == null) return 0;
        
        int leftLength = longestZigZag_01(node.left,1);
        int rightLength = longestZigZag_01(node.right,2);
        
        if(path == 1){
            if(rightLength+1>longest) longest = rightLength+1;
            return rightLength+1;
        }
        else if(path == 2){
            if(leftLength+1>longest) longest = leftLength+1;
            return leftLength+1;
        }
        else return Math.max(leftLength,rightLength);
    }
    public int longestZigZag(TreeNode root) {
       int ans = longestZigZag_01(root,0);
        System.out.print(ans);
        if(ans>longest) longest = ans;
        return longest;
    }
}