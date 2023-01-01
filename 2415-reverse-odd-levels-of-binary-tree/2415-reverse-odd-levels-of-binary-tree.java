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
    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int level = 0;
        while(que.size()!=0) {
            int size = que.size();
            while(size-- >0) {
                TreeNode removeN = que.removeFirst();
                if(removeN.left != null) que.addLast(removeN.left);
                if(removeN.right != null) que.addLast(removeN.right);
            }
            level ++;
            if(level%2 != 0 && que.size()!=0) {
                int[] arr = new int[que.size()];
                int i=0;
                for(TreeNode node : que) {
                    arr[i++] = node.val;
                }
                i--;
                for(TreeNode node : que) {
                    node.val = arr[i--]; 
                }
            }
        }
        return root;
    }
}