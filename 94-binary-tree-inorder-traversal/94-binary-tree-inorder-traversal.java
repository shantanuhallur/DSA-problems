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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        LinkedList<Integer> output_arr = new LinkedList<>();
        
        if(root == null)return output_arr;
        
        TreeNode curr = root;
        //there are elements left to traverse if stack is not empty
        while(curr!=null || !st.isEmpty()){
            //go untill the end of left subtree
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            //add the stack top to answer
            curr = st.pop();
            output_arr.add(curr.val);
            //go right once to explore.
            curr=curr.right;
           
        }
        return output_arr;
    }
}