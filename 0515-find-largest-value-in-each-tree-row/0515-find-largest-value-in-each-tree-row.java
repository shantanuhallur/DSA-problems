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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        que.addLast(root);
        while(que.size()!=0) {
            int size = que.size();
            int largest = que.peek().val; 
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                
                if(removeN.left!=null) {
                    que.addLast(removeN.left);
                }
                
                if(removeN.right!=null) {
                    que.addLast(removeN.right);
                }
                
                if(removeN.val >= largest)largest = removeN.val;
            }
            ans.add(largest);
        }
        
        return ans;
    }
}