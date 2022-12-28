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
        TreeNode node;
        int id;
        pair(TreeNode node,int id) {
            this.node = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(root,0));
        //start level order traversal
        while(que.size()!=0) {
            int size = que.size();
            int startId = 0;
            int endId = 0;
            for(int i =0;i<size;i++) {
                pair removeP = que.removeFirst();
                //LEFT CHILD myNode id * 2 +1
                if(removeP.node.left != null){
                    que.addLast(new pair(removeP.node.left, removeP.id*2 + 1));
                }
                //LEFT CHILD myNode id * 2 +2
                if(removeP.node.right != null){
                    que.addLast(new pair(removeP.node.right, removeP.id*2 + 2));
                }
                //to capture Starting id
                if(i==0) startId = removeP.id;
                if(i==size-1) endId = removeP.id;
            }
            //Keep maximized updated width at each level
            width = Math.max(width,endId-startId+1);
        }
        return width;
    }
}