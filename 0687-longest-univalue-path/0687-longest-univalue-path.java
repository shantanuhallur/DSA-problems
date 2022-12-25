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
        int height;
         pair(int data,int height) {
             this.data = data;
             this.height = height;
         }
    }
    int ans = 0;
    public pair dfs(TreeNode node) {
        if(node == null) return new pair(0,0);
        
        pair leftAns = dfs(node.left);
        pair rightAns = dfs(node.right);
        pair myPair = new pair(node.val,1);
        //Cases for ans and myPair
        if(leftAns.data == node.val && node.val == rightAns.data) {
            //for myPair
            myPair.height = Math.max(leftAns.height,rightAns.height) +1;
            //for ans
            ans = Math.max(ans,leftAns.height + rightAns.height + 1);
        }
        else if(leftAns.data == node.val) {
            //for myPair
            myPair.height = leftAns.height+1;
            //for ans
            ans = Math.max(ans,myPair.height);
        }
        else if(rightAns.data == node.val) {
            //for myPair
            myPair.height = rightAns.height+1;
            //for ans
            ans = Math.max(ans,myPair.height);
        }
        else {
            //for ans
            ans = Math.max(ans,1);
            //for myPair
            myPair.height = 1;
        }
        return myPair;
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans-1;
    }
}