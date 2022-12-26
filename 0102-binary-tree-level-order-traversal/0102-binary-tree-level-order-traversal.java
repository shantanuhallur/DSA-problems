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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
      //Create an answer List
        List<List<Integer>> ans = new ArrayList<>();
        //Create a Queue
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        //WHILE LOOP
        while(que.size()!=0) {
            List<Integer> levelAns = new ArrayList<>();
            int size = que.size();
            //Processing of Nodes in the same Level
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                //SET UP THE NEXT LEVEL.
                if(removeN.left != null){
                    que.addLast(removeN.left);
                }
                
                if(removeN.right != null){
                    que.addLast(removeN.right);
                }
                
                levelAns.add(removeN.val);
            }
            ans.add(levelAns);
        }
        return ans;
    }
}