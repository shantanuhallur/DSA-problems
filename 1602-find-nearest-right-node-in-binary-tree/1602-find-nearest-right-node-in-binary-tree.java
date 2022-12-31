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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        TreeNode ans = null;
        //Level Order Traversal
        while(que.size()!=0) {
            int size = que.size();
            //Set up the next level in que
            for(int i=0;i<size;i++) {
                TreeNode removeN = que.removeFirst();
                
                //add left and right nodes if exist
                if(removeN.left != null) {
                    que.addLast(removeN.left);
                }
                
                if(removeN.right !=null) {
                    que.addLast(removeN.right);
                }
                //Check if current removeN is our U node
                if(removeN.val == u.val && i!=size-1) {
                    ans = que.peekFirst();
                }
            }
        } 
        return ans;
    }
}