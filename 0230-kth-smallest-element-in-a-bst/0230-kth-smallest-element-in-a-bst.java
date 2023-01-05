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
    public void insertAllLeft(TreeNode node,LinkedList<TreeNode> st) {
        while(node!=null) {
            st.addLast(node);
            node = node.left;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        
        insertAllLeft(root,st);
        while(k-->1) {
            TreeNode removeN = st.removeLast();
            insertAllLeft(removeN.right,st);
        }
        return st.removeLast().val;
    }
}