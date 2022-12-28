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
    public class pair {
        int data;
        TreeNode node;
        
        pair(TreeNode node,int data) {
            this.node = node;
            this.data = data;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(root,0));
        int ans = 0;
        while(que.size()!=0) {
            int startId=0;
            int endId = 0;
            int size = que.size();
            for(int i=0;i<size;i++) {
                pair removeP = que.removeFirst();
                if(removeP.node.left!=null)que.addLast(new pair(removeP.node.left,removeP.data*2+1));
                
                if(removeP.node.right!=null)que.addLast(new pair(removeP.node.right,removeP.data*2+2));
            
            if(i==0) startId = removeP.data;
            if(i==size-1) endId = removeP.data;
            }
            ans = Math.max(ans,endId-startId+1);
        }
        return ans;
    }
}