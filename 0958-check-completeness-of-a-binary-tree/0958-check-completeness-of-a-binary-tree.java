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
    public boolean isCompleteTree(TreeNode root) {
        boolean end=false;
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.addLast(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.removeFirst();
            if(curr==null){
                end=true;
            }
            else{
                if(end)return false;
                q.addLast(curr.left);
                q.addLast(curr.right);
            }
        }
        return true;
    }
}