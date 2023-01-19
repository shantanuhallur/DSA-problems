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
    public class pair {
        int data;
        int extendingLen;
        pair(int data,int extendingLen) {
            this. data = data;
            this.extendingLen = extendingLen;
        }
    }
    int ans = -1;
    public pair dfs(TreeNode node) {
        if(node == null) return new pair(-1001,0);
        pair lAns = dfs(node.left);
        pair rAns = dfs(node.right);
        pair myPair = new pair(node.val,1);
        
        if(node.val == lAns.data && node.val == rAns.data) {
            myPair.extendingLen = Math.max(lAns.extendingLen,rAns.extendingLen) + 1;
            ans = Math.max(ans,lAns.extendingLen + rAns.extendingLen + 1);
        }
        else if(node.val == lAns.data) {
            myPair.extendingLen = lAns.extendingLen + 1;
            ans = Math.max(ans,myPair.extendingLen);
        }
        else if(node.val == rAns.data) {
            myPair.extendingLen = rAns.extendingLen + 1;
            ans = Math.max(ans,myPair.extendingLen);
        }
        else {
            ans = Math.max(ans,myPair.extendingLen);
        }
        return myPair;
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return ans-1;
    }
}