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
        //If tree Doesnt exist
        if(root == null) return 0;
        int sum = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        //Start Level Order Traversal
        while(que.size()!=0) {
            int size = que.size();
            //initialize sum = 0 for each new levl
            sum = 0;
            while(size-- >0) {
                
                TreeNode removeN = que.removeFirst();
                //If left and right exists add in que
                if(removeN.left != null) que.addLast(removeN.left);
                
                if(removeN.right != null) que.addLast(removeN.right);
                //add all the nodes sum of same level in sum.
                sum += removeN.val;
            }
        }
        return sum;
    }
}