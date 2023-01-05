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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int maxSumLevel = 1;
        int maxSum = -(int)1e6;
        int level = 1;
        while(que.size()!=0) {
            int sum = 0;
            int size = que.size();
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                
                sum += removeN.val;
                if(removeN.left!=null) que.addLast(removeN.left);
                if(removeN.right!=null) que.addLast(removeN.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                maxSumLevel = level;
            }
            level++;
        }
        return maxSumLevel;
    }
}