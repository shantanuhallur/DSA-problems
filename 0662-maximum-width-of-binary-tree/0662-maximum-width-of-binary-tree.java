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
    public class pair{
        TreeNode node;
        int id;
        pair(TreeNode node,int id) {
            this.node = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(root,0));
        int ans = -1;
        while(que.size()!=0) {
            int size = que.size();
            int firstNodeId = 0; int lastNodeId=0;
            for(int i=0;i<size;i++) {
                pair removeP = que.removeFirst();
                
                if(removeP.node.left!=null) {
                    que.addLast(new pair(removeP.node.left,removeP.id*2+1));
                }
                
                if(removeP.node.right!=null) {
                    que.addLast(new pair(removeP.node.right,removeP.id*2+2));
                }
                
                if(i==0) firstNodeId = removeP.id;
                if(i==size-1) lastNodeId = removeP.id;
            }
            ans = Math.max(ans,lastNodeId-firstNodeId+1);
        }
        return ans;
    }
}