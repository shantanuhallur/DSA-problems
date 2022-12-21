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
    public void postorderTraversal_01(TreeNode node,ArrayList<Integer> ans) {
        //Base Case return if node is null.
        if(node == null) return;
        //Left Recursive Call
        postorderTraversal_01(node.left,ans);
        //Right Recursive Call
        postorderTraversal_01(node.right,ans);
        //PostOrder Work
        ans.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        postorderTraversal_01(root,ans);
        return ans;
    }
}