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
        while(que.size()!=0) {
            int size = que.size();
            int evenS = -1;
            int oddS = (int)1e8;
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                
                //EVEN LEVEL
                if(level%2 == 0) {
                    if(rn.val%2 !=1 || rn.val <= evenS) return false;
                    evenS = rn.val;
                }
                //ODD LEVEL
                else {
                    if(rn.val%2 !=0 || rn.val >= oddS) return false;
                    oddS = rn.val;
                }
                if(rn.left != null) que.addLast(rn.left);
                
                if(rn.right != null) que.addLast(rn.right);
            }
            level++;
        }
        return true;
    }
}