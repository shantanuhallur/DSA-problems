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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //Base Case
        if(depth == 1) {
            TreeNode base = new TreeNode(val);
            base.left = root;
            return base;
        }
        //Create a level for while loop's break condition
        int level = 1;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(level < depth -1){
            int size = que.size();
            while(size-->0) {
                //Remove the Node from the que
                TreeNode removeN = que.removeFirst();
                //Add the node's children if exist.
                if(removeN.left != null) {
                    que.addLast(removeN.left);
                }
                if(removeN.right != null) {
                    que.addLast(removeN.right);
                }
            }
            level++;
        }
        
        while(que.size()!=0) {
            TreeNode removeN = que.removeFirst();
            // Create temp nodes for not loosing our subtrees in left or right.
            TreeNode temp1 = removeN.left;
            TreeNode temp2 = removeN.right;
            //create nodes we want to add.
            TreeNode leftN = new TreeNode(val);
            TreeNode rightN = new TreeNode(val);
            //attach these nodes
            removeN.left = leftN;
            removeN.right = rightN;
            leftN.left = temp1;
            rightN.right = temp2;
        }
        
        return root;
    }
}