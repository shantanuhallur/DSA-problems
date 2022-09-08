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
    public int deepestLeavesSum(TreeNode root) {
        int sum=0;
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
             sum = 0;
            for(int i=0;i<size;i++){
                TreeNode curr_node = q.remove();
                
                sum += curr_node.val;
                
                if(curr_node.left !=null)q.offer(curr_node.left);
            
                if(curr_node.right !=null)q.offer(curr_node.right);
            }
            
            
        }
        return sum;
    }
}