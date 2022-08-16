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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> sumst = new Stack<>();
        
        st.push(root);
        sumst.push(targetSum-root.val);
        
        while(st.size()>0){
            TreeNode currNode = st.pop();
            int curr_sum = sumst.pop();
            
            if(currNode.left == null && currNode.right == null && curr_sum==0)return true;
            
            if(currNode.left!=null){
                st.push(currNode.left);
                sumst.push(curr_sum-currNode.left.val);
            }
            
            if(currNode.right!=null){
                st.push(currNode.right);
                sumst.push(curr_sum-currNode.right.val);
            }
        }
        return false;
    }
}