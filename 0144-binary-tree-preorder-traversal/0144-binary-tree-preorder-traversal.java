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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Base case
        List<Integer> list = new ArrayList<>();
        if(root==null)  return list;
        
        LinkedList<TreeNode> st = new LinkedList<>();
        //add root node
        st.addLast(root);
        //while our stack is not empty
        while(st.size()!=0) {
            //Remove the node from last
            TreeNode removeN = st.removeLast();
            
            //add right node if exists
            if(removeN.right != null) {
                st.addLast(removeN.right);
            }
            //add left node if exists
            if(removeN.left != null) {
                st.addLast(removeN.left);
            }
            
            list.add(removeN.val);
        }
        
        return list;
    }
}