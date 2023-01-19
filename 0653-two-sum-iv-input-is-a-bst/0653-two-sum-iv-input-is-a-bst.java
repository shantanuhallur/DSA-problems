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
    public void insertAllLeft(TreeNode node,Stack<TreeNode> st) {
        while(node!=null) {
            st.push(node);
            node = node.left;
        }
    }
    public void insertAllRight(TreeNode node, Stack<TreeNode> st) {
        while(node!=null) {
            st.push(node);
            node = node.right;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        insertAllLeft(root,st1);
        insertAllRight(root,st2);
        while(st1.peek().val < st2.peek().val) {
            int sum = st1.peek().val + st2.peek().val;
            if(sum> k) {
                TreeNode rn = st2.peek(); st2.pop();
                insertAllRight(rn.left,st2);
               
            }
            else if(sum < k) {
                TreeNode rn = st1.peek(); st1.pop();
                insertAllLeft(rn.right,st1);
            }
            else if(sum == k) return true;
        }
        return false;
    }
}