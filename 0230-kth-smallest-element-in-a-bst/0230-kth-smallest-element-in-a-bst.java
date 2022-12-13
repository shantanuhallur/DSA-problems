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
    
    public void insertLeftMost(LinkedList<TreeNode> st , TreeNode node) {
        while(node !=null) {
            st.addFirst(node);
            node = node.left;   
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        insertLeftMost(st,root);
        TreeNode node = null;
        while(k-->0) {
            node = st.removeFirst();
            insertLeftMost(st,node.right);
        }
        return node.val;
    }
}