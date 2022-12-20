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
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> ans = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        int level = 0;
        que.addFirst(root);
        
        while(que.size()!=0) {
            int size = que.size();
            double orSize = size;
            double levelAns = 0;
            while(size-- >0) {
                TreeNode rn = que.removeFirst();
                levelAns += rn.val;
                
                if(rn.left != null) {
                    que.addLast(rn.left);
                }
                
                if(rn.right != null) {
                    que.addLast(rn.right);
                }
            }
            ans.addLast(levelAns/orSize);
            level++;
        }
        return ans;
    }
}