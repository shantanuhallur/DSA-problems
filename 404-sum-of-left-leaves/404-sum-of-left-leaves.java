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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        int sum=0;
        Stack<TreeNode> q = new Stack<>();
        q.push(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.pop();
            
            if(curr.left != null){
                if(curr.left.left == null && curr.left.right==null){
                    sum += curr.left.val;
                }
                else{
                    q.push(curr.left);
                }
            }
                if(curr.right!=null){
                    if(curr.right.left!=null || curr.right.right!= null){
                        q.push(curr.right);
                    }
                }
            
        }
        return sum;
    }
}