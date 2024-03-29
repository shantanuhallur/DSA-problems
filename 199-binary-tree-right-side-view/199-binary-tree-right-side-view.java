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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        
        
        while(!q.isEmpty()){
            int size = q.size();
            //size so that we can separate nodes at every level from the Q
            for(int i=0;i<size;i++){
                TreeNode currNode = q.poll();
                if(i==0)ans.add(currNode.val); //firstNode will be our Answer.
                if(currNode.right!=null)q.offer(currNode.right);
                if(currNode.left!=null)q.offer(currNode.left);
            }
            
        }
        return ans;
    }
}