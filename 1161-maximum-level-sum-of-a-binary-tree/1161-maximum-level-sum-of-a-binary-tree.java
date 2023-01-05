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
    public int maxLevelSum(TreeNode root) {
        int AnsLevel = 1;
        int maxSum = -(int)1e6;
        int level = 1;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        //Level order traversal.
        while(que.size()!=0) {
            int size = que.size();
            int levelSum=0;
            while(size-->0) {
                //remove node
                TreeNode removeN = que.removeFirst();
                //add each nodes value of this level in level sum
                levelSum += removeN.val;
                //set up next level of the que
                if(removeN.left !=null)que.addLast(removeN.left);
                if(removeN.right !=null)que.addLast(removeN.right);
            }
            //updation of maxlevel if required
            if(maxSum<levelSum) {
                maxSum = levelSum;
                AnsLevel = level;
            }
            //go to next level
            level++;
        }
        return AnsLevel;
    }
}