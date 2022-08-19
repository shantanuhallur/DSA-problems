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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum =0;
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.val>=low && root.val<=high){
                sum+=root.val;
            }
            if(root.val >= low && root.left!=null){
                q.offer(root.left);

            }
             if(root.val <= high && root.right!=null){
                q.offer(root.right);

            }
        }
        return sum;
    }
}