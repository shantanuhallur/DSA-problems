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
    public void addAllLeft(TreeNode node,Stack<TreeNode> st) {
        while(node!= null){
            st.push(node);
            node= node.left;
        }
    }
    public void addAllRight(TreeNode node, Stack<TreeNode> st) {
        while(node!=null) {
            st.push(node);
            node = node.right;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        //setup of stack 1 and stack 2
        addAllLeft(root,st1);
        addAllRight(root,st2);
        // start 2 pointer approach
        while(st1.peek().val<st2.peek().val) {
            int sum = st1.peek().val + st2.peek().val;
            if(sum==k) return true;
            else if(sum > k) {
                TreeNode rn = st2.pop();
                addAllRight(rn.left,st2);
            }
            else if(sum < k) {
                TreeNode rn =st1.pop();
                addAllLeft(rn.right,st1);
            }
        }
        return false;
    }
}