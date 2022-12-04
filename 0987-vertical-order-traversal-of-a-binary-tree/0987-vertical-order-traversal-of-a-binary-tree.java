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
        public static class verticalPair {
        int hl=0;
        TreeNode node=null;

        verticalPair(TreeNode node, int hl ) {
            this.node = node;
            this.hl = hl;
        }
    }
    
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<verticalPair> que = new PriorityQueue<>((a,b) -> {
            return a.node.val-b.node.val;
        });
        PriorityQueue<verticalPair> childQue = new PriorityQueue<>((a,b) -> {
            return a.node.val-b.node.val;
        });
        
        que.add(new verticalPair(root, 0));
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int maxHL = -(int)1e9;
        int minHL = (int)1e9;
        while(que.size()!= 0) {
            int size = que.size();
            while(size-- >0) {
                verticalPair rp = que.remove();

                map.putIfAbsent(rp.hl, new ArrayList<>());
                map.get(rp.hl).add(rp.node.val); //get that list of the level and then add this node's val into it.
                maxHL = Math.max(maxHL,rp.hl);
                minHL = Math.min(minHL,rp.hl);

                if(rp.node.left != null) {
                    childQue.add(new verticalPair(rp.node.left, rp.hl-1));
                }

                if(rp.node.right != null) {
                    childQue.add(new verticalPair(rp.node.right, rp.hl+1));
                }
                
                if(que.size()==0) {
                    PriorityQueue<verticalPair> temp = childQue;
                    childQue = que;
                    que = temp;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while(minHL <= maxHL) {
            ans.add(map.get(minHL));
            minHL++;
        }

        return ans;
    }
}