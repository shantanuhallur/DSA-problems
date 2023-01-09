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
    public void insertAllLeftNodes(TreeNode node,LinkedList<TreeNode> st) {
        while(node!=null) {
            st.addLast(node);
            node = node.left;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> st = new LinkedList<>();
        //first insert all left nodes of root in stack
        insertAllLeftNodes(root,st);
        //run while loop to get nodes in sorted order
        while(k-->1) {
            //get removeN from stack
            TreeNode removeN = st.removeLast();
            insertAllLeftNodes(removeN.right,st);
        }
       return st.removeLast().val; 
    }
}