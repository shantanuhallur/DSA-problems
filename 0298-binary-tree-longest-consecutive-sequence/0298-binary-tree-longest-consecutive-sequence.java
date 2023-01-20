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
    int ans = 1;
    
    public void getLongestSequence(TreeNode node,int parVal,int parStreak) {
        //Base Case
        if(node == null) return;
        //current nodes fresh streak
        int currStreak = 1;
        if(node.val == parVal + 1) currStreak += parStreak;
        //Recursive left and right call
        ans = Math.max(ans,currStreak);
        getLongestSequence(node.left,node.val,currStreak);
        getLongestSequence(node.right,node.val,currStreak);
    }
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        getLongestSequence(root,root.val,0);
        return ans;
    }
}