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
    class Pair{
        int num;
        TreeNode node;
            Pair( TreeNode _node,int _num){
                this.num = _num;
                this.node = _node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
       int ans = 0;
        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num; //min is the first Pair's num at that level;
            int first=0,last=0; //first and last for that level;
            for(int i=0;i<size;i++){
                int curr_id = q.peek().num-mmin; // curr_id needs to be set for each                                             node in that level ranging from 1 to node n;
                TreeNode node = q.peek().node; //get the node
                q.poll(); //remove the node;
                if(i==0)first = curr_id; //first will be initialized at first node at                                              that level
                if(i==size-1) last = curr_id; //as obviously last node at that leevel                                                   will be the last curr_id at that level.
                //for left node first curr_id*2+1
                if(node.left!=null){
                    q.offer(new Pair(node.left,curr_id*2+1));
                }
                //for right node second curr_id*2+2
                if(node.right!=null){
                    q.offer(new Pair(node.right,curr_id*2+2));
                }
            }
            //Maximize answer at that level;
            ans = Math.max(ans,last-first+1);
            
        }
        return ans;
    }
}