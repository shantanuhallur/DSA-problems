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
        if(root==null) return 0;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int sum = 0;       
        while(que.size()!= 0) {
            int size = que.size();
            sum = 0;
            while(size-- >0) {
                TreeNode removeN = que.removeFirst();
                
                if(removeN.left != null) {
                    que.addLast(removeN.left);
                }
                
                if(removeN.right != null) {
                    que.addLast(removeN.right);
                }
                
                sum += removeN.val; 
            }
        }
        return sum;
    }
}