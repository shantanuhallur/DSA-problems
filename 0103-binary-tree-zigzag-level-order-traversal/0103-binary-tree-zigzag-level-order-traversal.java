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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        //prepare the que
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int level = 1;
        //Begin Level Order Traversal
        while(que.size()!=0) {
            LinkedList<Integer> levelAns = new LinkedList<>();
            int size = que.size();
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                //Set up next level in the que
                if(removeN.left != null) {
                    que.addLast(removeN.left);
                }
                
                if(removeN.right != null) {
                    que.addLast(removeN.right);
                }
                //IF LEVEL EVEN ---->>>>
                if(level%2==0) {
                    levelAns.addFirst(removeN.val);
                }//ELSE IF LEVEL ODD -->>>>>>
                else{
                    levelAns.addLast(removeN.val);
                }
            }
            //Increament the level as the processing of this level is finished.
            level++;
            //add the created level's ans in our main ans.
            ans.add(levelAns);
        }
        return ans;
    }
}