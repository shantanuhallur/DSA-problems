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
    public boolean isUnivalTree_01(TreeNode root,int val) {
        //Base
        if(root==null) return true;
        //Left Recursive Call
        boolean hasSameLeftVal = isUnivalTree_01(root.left,val);
        //Right Recursive Call
        boolean hasSameRightVal = isUnivalTree_01(root.right,val);
        
        if(hasSameLeftVal && hasSameRightVal && root.val == val) return true;
        else return false;
    }
    public boolean isUnivalTree(TreeNode root) {
        //Base
        if(root==null) return true;
        int val = root.val;
        return isUnivalTree_01(root,val);
    }
}