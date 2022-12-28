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
        boolean treeEnd = false;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size()!=0) {
            TreeNode removeN = que.removeFirst();
            //check if removeN is null
            if(removeN == null) {
                treeEnd = true;
            }
            else{
                //check if tree has already ended
                if(treeEnd == true) return false;
                
                que.addLast(removeN.left);
                que.addLast(removeN.right);
            }
        }
        
        return true;
    }
}