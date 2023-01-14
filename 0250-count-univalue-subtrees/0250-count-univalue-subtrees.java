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
    int ans =0;
    public boolean findSubtree(TreeNode node,int checkVal) {
        //Base Case
        if(node==null) return true;
        int checkValForMyNodesSubtree = node.val;
        //left and right recursive call
        boolean allLeftEqual = findSubtree(node.left,checkValForMyNodesSubtree);
        boolean allRightEqual = findSubtree(node.right,checkValForMyNodesSubtree);
        //Univalue subtree if ->
        if(allLeftEqual == true && allRightEqual == true) ans++;
        //return condition
        if(allLeftEqual == true && allRightEqual == true && node.val == checkVal) return true;
        return false;
    }
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        findSubtree(root,root.val);
        return ans;
    }
}