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
        if(root==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        //Create que for level order traversal
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        //Begin BFS
        while(que.size()!=0) {
            int size = que.size();
            //Inner while loop for each level
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                //SETUP next level in que
                if(removeN.left !=null) {
                    que.addLast(removeN.left);
                }
                
                if(removeN.right !=null) {
                    que.addLast(removeN.right);
                }
                //Add last node of this level in our ans
                if(size==0) ans.add(removeN.val);
            }
        }
        return ans;
    }
}