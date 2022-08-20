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
    public void flatten(TreeNode root) {
       if(root==null)return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode currNode = st.pop();
            if(currNode.right!=null)st.push(currNode.right);
            if(currNode.left!=null)st.push(currNode.left);
            if(!st.isEmpty())currNode.right=st.peek();
            currNode.left=null;
        }
    }
}