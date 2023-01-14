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
    int ans = 0;
    public boolean getCount(TreeNode node,int checkVal) {
        if(node == null) return true;
        int checkFormySubtreeVal = node.val;
        boolean leftAns = getCount(node.left,checkFormySubtreeVal);
        boolean rightAns = getCount(node.right,checkFormySubtreeVal);
        
        if(leftAns == true && rightAns == true) ans++;
        
        if(leftAns == true && rightAns == true && node.val == checkVal) return true;
        return false;
    }
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        getCount(root,root.val);
        return ans;
    }
}