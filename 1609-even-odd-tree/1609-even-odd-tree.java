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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int level = 0;
        //LVL ORDER TRAVERSAL/BFS
        while(que.size()!=0) {
            int size = que.size();
            int increasing = -1;
            int decreasing = (int)1e8;
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                
                //Even Level -- ODD -- strictly increasing
                if(level%2==0){
                    if(removeN.val % 2 == 0 || increasing >= removeN.val) return false;
                    increasing = removeN.val;
                }
                //Odd level
                else{
                    if(removeN.val % 2 == 1 || decreasing <= removeN.val) return false;
                    decreasing = removeN.val;
                }
                //set up the next level inside the que
                if(removeN.left!=null)que.addLast(removeN.left);
                
                if(removeN.right!=null)que.addLast(removeN.right);
                
            }
            //increasing the level.
            level ++;
        }
        return true;
    }
}