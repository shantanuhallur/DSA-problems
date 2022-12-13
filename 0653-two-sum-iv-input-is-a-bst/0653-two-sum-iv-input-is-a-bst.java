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
    public static void insertAllLeft(Stack<TreeNode> st, TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public static void insertAllRight(Stack<TreeNode> st, TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.right;
        }
    }

    // 653
    public static boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Stack<TreeNode> lst = new Stack<>();
        Stack<TreeNode> rst = new Stack<>();

        insertAllLeft(lst, root);
        insertAllRight(rst, root);

        while (lst.peek().val < rst.peek().val) {

            int sum = lst.peek().val + rst.peek().val;
            if (sum == k)
                return true;
            else if (sum < k) {
                TreeNode node = lst.pop();
                insertAllLeft(lst, node.right);
            } else {
                TreeNode node = rst.pop();
                insertAllRight(rst, node.left);
            }
        }
        return false;
    }
}