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
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size()!=0) {
            //remove the node from the que
            root = que.removeFirst();
            // add first right child then left child.
            if(root.right != null) que.addLast(root.right);
            
            if(root.left != null) que.addLast(root.left); 
        
        }
        //Now we have our leftmost node saved in root.
        return root.val;
    }
}