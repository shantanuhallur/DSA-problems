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
    public void averageOfLevels_01(TreeNode node,List<Double> ans) {
        //Create a que and add root node.
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(node);
        
        while(que.size()!=0) {
            double size = que.size();
            double originalSize = size;
            double sum = 0;
            while(size-->0) {
                TreeNode removeN = que.pop();
                sum += removeN.val;
                //add childs of next level
                if(removeN.left !=null) {
                    que.addLast(removeN.left);
                }
                
                if(removeN.right !=null) {
                    que.addLast(removeN.right);
                }
            }
            ans.add(sum/originalSize);
        }
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        averageOfLevels_01(root,ans);
        return ans;
    }
}